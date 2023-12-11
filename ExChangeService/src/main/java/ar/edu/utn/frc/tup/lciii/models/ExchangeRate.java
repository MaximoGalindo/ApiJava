package ar.edu.utn.frc.tup.lciii.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class ExchangeRate {
    private String from;
    private String to;
    private BigDecimal exchange_rate;

    public ExchangeRate(String from, String to, BigDecimal exchangeRate) {
        this.from = from;
        this.to = to;
        this.exchange_rate = exchangeRate;
    }
}