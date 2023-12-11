package ar.edu.utn.frc.tup.lciii.models.cars;

import ar.edu.utn.frc.tup.lciii.models.price.Price;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cars {
    private Long id;
    private String model;
    private String brand;
    private Price price;
}