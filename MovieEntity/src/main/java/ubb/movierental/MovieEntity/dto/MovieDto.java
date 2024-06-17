package ubb.movierental.MovieEntity.dto;

import lombok.*;
import ubb.movierental.MovieEntity.model.AgeRestrictions;
import ubb.movierental.MovieEntity.model.MovieGenres;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MovieDto {
    private Long id;
    private String title;
    private Integer year;
    private MovieGenres genre;
    private AgeRestrictions ageRestrictions;
    private Double rentalPrice;
    private boolean available;


    @Override
    public String toString() {
        return "MovieDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", genre=" + genre +
                ", ageRestrictions=" + ageRestrictions +
                ", rentalPrice=" + rentalPrice +
                ", available=" + available +
                '}';
    }
}
