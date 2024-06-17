package ubb.movierentals.RentalEntity.service;

import io.grpc.StatusRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ubb.movierentals.RentalEntity.exception.DataBaseOperationException;
import ubb.movierentals.RentalEntity.exception.ResourceNotFoundException;
import ubb.movierentals.RentalEntity.model.Rental;
import ubb.movierentals.RentalEntity.repository.RentalRepository;
import ubb.movierentals.grpc.MovieOuterClass;
import ubb.movierentals.grpc.MovieServiceRPCGrpc;

import java.util.List;
import java.util.Optional;

@Service
public class RentalServiceImpl implements IRentalService {
    private static final Logger log = LoggerFactory.getLogger(RentalServiceImpl.class);

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @Autowired
    private MovieClientService movieClientService;

    @Autowired
    private MovieServiceRPCGrpc.MovieServiceRPCBlockingStub movieServiceStub;

    @Override
    public List<Rental> getAllRentals() {
        log.trace("getAllRentals --- method entered");
        List<Rental> rentals = rentalRepository.findAll();
        log.trace("getAllRentals {}", rentals.size());
        if(rentals.isEmpty()) {
            log.error("getAllRentals --- no rentals found");
            throw new ResourceNotFoundException("No Rentals found.");
        }
        log.trace("getAllRentals: rentals={}", rentals);
        return rentals;
    }

    @Override
    public Rental getRentalById(Long id) {
        log.trace("getRentalById --- method entered");
        Optional<Rental> optionalRental = rentalRepository.findById(id);
        if(optionalRental.isEmpty()) {
            log.error("getRentalById --- no rental found");
            throw new ResourceNotFoundException("Rental not found.");
        }
        Rental result = optionalRental.get();
        log.trace("getRentalById: result={}", result);
        return result;
    }

    @Override
    public Rental rentAMovie(Rental rental) {
        log.trace("rentAMovie --- method entered");

        Long movieId = rental.getMovieId();
        try {

            // Make RPC call using the injected gRPC stub
            MovieOuterClass.GetMovieResponse response = movieServiceStub.getMovieById(
                    MovieOuterClass.GetMovieRequest.newBuilder()
                            .setMovieId(rental.getMovieId())
                            .build());
            log.info("Received response: " + response);

            MovieOuterClass.Movie movie = movieClientService.getMovieById(movieId);
            double amount = movie.getRentalPrice();
            rental.setAmount(amount);

            Rental savedRental = rentalRepository.save(rental);
            log.trace("rentAMovie: savedRental={}", savedRental);
            rabbitMQSender.send("New Movie Rental.");
            return savedRental;
        } catch (StatusRuntimeException e) {
            log.error("gRPC call failed: {}", e.getStatus());
            rabbitMQSender.send("Failed to save new Movie Rental.");
            throw new RuntimeException("Error while retrieving movie: " + e.getMessage(), e);
        } catch (DataIntegrityViolationException e) {
            rabbitMQSender.send("Failed to save new Movie Rental.");
            log.error("Error while saving rental: {}", e.getMessage());
            throw new DataBaseOperationException("Error while saving rental: " + e.getMessage());
        } catch (Exception e) {
            log.error("Unexpected error: {}", e.getMessage());
            rabbitMQSender.send("Failed to process new Movie Rental.");
            throw new RuntimeException("Unexpected error: " + e.getMessage(), e);
        }
    }

    @Transactional
    @Override
    public Rental updateRentalTransaction(Long rentalId, Rental rental) {
        log.trace("updateRentalTransaction --- method entered");
        Optional<Rental> rentalOptional = rentalRepository.findById(rentalId);

        if(rentalOptional.isPresent()) {
            Rental updatedRental = rentalOptional.get();
            log.trace("updateRentalTransaction: updatedRental={}", updatedRental);

            // use GRpc MovieService
            Long movieId = updatedRental.getMovieId();
            MovieOuterClass.Movie movie = movieClientService.getMovieById(movieId);
            double amount = movie.getRentalPrice();

            updatedRental.setMovieId(rental.getMovieId());
            updatedRental.setClientId(rental.getClientId());
            updatedRental.setAmount(amount);
            updatedRental.setDiscount(rental.getDiscount());
            updatedRental.setRentDate(rental.getRentDate());
            updatedRental.setDuration(rental.getDuration());
            updatedRental.setDueDate(rental.getDueDate());

            Rental savedRental = rentalRepository.save(updatedRental);
            log.trace("updateRentalTransaction: savedRental={}", savedRental);
            rabbitMQSender.send("Rental transaction updated.");

            return savedRental;
        } else {
            rabbitMQSender.send("Failed to update Rental transaction.");
            log.error("updateRentalTransaction --- no rentals found");
            throw new ResourceNotFoundException("No Rentals found.");
        }
    }

    @Override
    public void deleteMovieRental(Long rentalId) {
        log.trace("deleteMovieRental --- method entered");
        if(rentalRepository.existsById(rentalId)) {
            rentalRepository.deleteById(rentalId);
            rabbitMQSender.send("Deleted Rental transaction.");
            log.trace("deleteMovieRental: rental deleted successfully");
        } else {
            rabbitMQSender.send("Failed to delete Rental transaction.");
            log.error("deleteMovieRental --- no rental found");
            throw new ResourceNotFoundException("No Rental found.");
        }
    }
}
