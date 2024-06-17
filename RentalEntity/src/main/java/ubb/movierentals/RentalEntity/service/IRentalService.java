package ubb.movierentals.RentalEntity.service;

import ubb.movierentals.RentalEntity.model.Rental;

import java.util.List;

public interface IRentalService {
    List<Rental> getAllRentals();

    Rental getRentalById(Long id);

    Rental rentAMovie(Rental rental);

    Rental updateRentalTransaction(Long rentalId, Rental rental);

    void deleteMovieRental(Long rentalId);

}
