package ar.edu.utn.frc.tup.lciii.dtos.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarsDTO {
    private String model;
    private String brand;
    private BigDecimal local_price;
}
