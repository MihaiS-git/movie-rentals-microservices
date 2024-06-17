package ubb.movierentals.RentalEntity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RentalDto {
    private Long id;
    @JsonProperty
    private Long movieId;
    @JsonProperty
    private Long clientId;
    @JsonProperty
    private Double amount;
    @JsonProperty
    private Double discount;
    @JsonProperty
    private LocalDate rentDate;
    @JsonProperty
    private Integer duration;
    @JsonProperty
    private LocalDate dueDate;

    @Override
    public String toString() {
        return "RentalDto{" +
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
