package ubb.movierental.MovieEntity.model;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "movies")
public class Movie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer year;

    @Enumerated(EnumType.STRING)
    private MovieGenres genre;

    @Enumerated(EnumType.STRING)
    @Column(name = "age_restriction")
    private AgeRestrictions ageRestrictions;

    @Column(name = "rental_price")
    private Double rentalPrice;

    private boolean available;

    public Movie(String title, int year, MovieGenres genre, AgeRestrictions ageRestrictions, double rentalPrice, boolean available) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.ageRestrictions = ageRestrictions;
        this.rentalPrice = rentalPrice;
        this.available = available;
    }

    @Override
    public String toString() {
        return "Movie{" +
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
