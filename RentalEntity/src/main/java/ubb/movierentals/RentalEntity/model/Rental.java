package ubb.movierentals.RentalEntity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "rentals")
public class Rental implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "movie_id")
    private Long movieId;

    @Column(name= "client_id")
    private Long clientId;

    private Double amount;
    private Double discount;

    @Column(name="rent_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentDate;

    private Integer duration;

    @Column(name="due_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", clientId=" + clientId +
                ", amount=" + amount +
                ", discount=" + discount +
                ", rentDate=" + rentDate +
                ", duration=" + duration +
                ", dueDate=" + dueDate +
                '}';
    }
}

