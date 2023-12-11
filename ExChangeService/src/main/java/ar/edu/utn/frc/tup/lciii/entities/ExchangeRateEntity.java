package ar.edu.utn.frc.tup.lciii.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "exchange_rate")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "currency_from")
    private String from;
    @Column(name = "currency_to")
    private String to;
    @Column(name = "exchange_rate")
    private BigDecimal exchange_rate;
}
