package ar.edu.utn.frc.tup.lciii.models.exchange_rate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;


@JsonIgnoreProperties(ignoreUnknown = true)
public record ExchangeRate(Date date, String from, String to, BigDecimal exchange_rate) {
    public ExchangeRate(String from, String to, BigDecimal exchange_rate){
        this(null,from,to,exchange_rate);
    }
    public ExchangeRate(@DateTimeFormat(pattern = "yyyy-MM-dd") Date date, String from, String to, BigDecimal exchange_rate) {
        this.date = date;
        this.from = from;
        this.to = to;
        this.exchange_rate = exchange_rate;
    }
}
