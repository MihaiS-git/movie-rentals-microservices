package ubb.movierentals.RentalEntity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ubb.movierentals.RentalEntity.converter.RentalConverter;
import ubb.movierentals.RentalEntity.exception.DataBaseOperationException;
import ubb.movierentals.RentalEntity.exception.ResourceNotFoundException;
import ubb.movierentals.RentalEntity.model.Rental;
import ubb.movierentals.RentalEntity.service.IRentalService;
import ubb.movierentals.RentalEntity.dto.RentalDto;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RentalController {

    @Autowired
    private IRentalService rentalService;

    @Autowired
    private RentalConverter rentalConverter;


    @RequestMapping(value = "/rentals", method = RequestMethod.GET)
    public ResponseEntity<List<RentalDto>> getRentals() {
        try {
            List<Rental> rentals = rentalService.getAllRentals();
            List<RentalDto> rentalDtos = rentals.stream()
                    .map(rental -> rentalConverter.convertModelToDto(rental))
                    .collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.OK)
                    .body(rentalDtos);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.emptyList());
        }
    }

    @RequestMapping(value = "/rentals/{rentalId}", method = RequestMethod.GET)
    public ResponseEntity<RentalDto> getRentalById(@PathVariable Long rentalId) {
        try {
            Rental rental = rentalService.getRentalById(rentalId);
            RentalDto rentalDto = rentalConverter.convertModelToDto(rental);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(rentalDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new RentalDto());
        }
    }

    @RequestMapping(value = "/rentals", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<RentalDto> saveRental(@RequestBody RentalDto dto) {
        try {
            Rental rental = rentalConverter.convertDtoToModel(dto);
            rental.setRentDate(LocalDate.now());
            rental.setDuration(1);
            rental.setDueDate(LocalDate.now().plusDays(1));
            rental.setDiscount(0.00);
            Rental savedRental = rentalService.rentAMovie(rental);
            RentalDto rentalDto = rentalConverter.convertModelToDto(savedRental);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(rentalDto);
        } catch (DataBaseOperationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new RentalDto());
        }
    }

    @RequestMapping(value = "/rentals/{rentalId}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<RentalDto> updateRental(
            @PathVariable final Long rentalId,
            @RequestBody final RentalDto dto) {
        try {
            Rental updatedRental = rentalService.updateRentalTransaction(rentalId, rentalConverter.convertDtoToModel(dto));
            RentalDto updatedRentalDto = rentalConverter.convertModelToDto(updatedRental);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(updatedRentalDto);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new RentalDto());
        }
    }

    @RequestMapping(value = "/rentals/{rentalId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteRental(@PathVariable Long rentalId) {
        try {
            rentalService.deleteMovieRental(rentalId);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new RentalDto());
        }
    }
}
