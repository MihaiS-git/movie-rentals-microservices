package ubb.movierental.MovieEntity.converter;

import org.springframework.stereotype.Component;
import ubb.movierental.MovieEntity.dto.MovieDto;
import ubb.movierental.MovieEntity.model.Movie;

@Component
public class MovieConverter  {

    public Movie convertDtoToModel(MovieDto dto) {
        Movie movie = Movie.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .year(dto.getYear())
                .genre(dto.getGenre())
                .ageRestrictions(dto.getAgeRestrictions())
                .rentalPrice(dto.getRentalPrice())
                .available(dto.isAvailable())
                .build();
        return movie;
    }

    public MovieDto convertModelToDto(Movie movie) {
        MovieDto dto = MovieDto.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .year(movie.getYear())
                .genre(movie.getGenre())
                .ageRestrictions(movie.getAgeRestrictions())
                .rentalPrice(movie.getRentalPrice())
                .available(movie.isAvailable())
                .build();
        return dto;
    }

}
