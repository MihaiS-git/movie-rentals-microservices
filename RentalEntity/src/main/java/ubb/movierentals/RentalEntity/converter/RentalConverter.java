package ubb.movierentals.RentalEntity.converter;

import org.springframework.stereotype.Component;
import ubb.movierentals.RentalEntity.dto.RentalDto;
import ubb.movierentals.RentalEntity.model.Rental;

@Component
public class RentalConverter {

    public Rental convertDtoToModel(RentalDto dto) {
        Rental rental = Rental.builder()
                .id(dto.getId())
                .movieId(dto.getMovieId())
                .clientId(dto.getClientId())
                .amount(dto.getAmount())
                .rentDate(dto.getRentDate())
                .duration(dto.getDuration())
                .dueDate(dto.getDueDate())
                .build();
        return rental;
    }

    public RentalDto convertModelToDto(Rental rental) {
        RentalDto rentalDto = RentalDto.builder()
                .id(rental.getId())
                .movieId(rental.getMovieId())
                .clientId(rental.getClientId())
                .amount(rental.getAmount())
                .discount(rental.getDiscount())
                .rentDate(rental.getRentDate())
                .duration(rental.getDuration())
                .dueDate(rental.getDueDate())
                .build();
        return rentalDto;
    }
}
