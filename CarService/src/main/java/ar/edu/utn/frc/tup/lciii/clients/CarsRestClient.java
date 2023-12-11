package ar.edu.utn.frc.tup.lciii.clients;

import ar.edu.utn.frc.tup.lciii.models.cars.Cars;
//import ar.edu.utn.frc.tup.lciii.models.exchange_rates.ExchangeRate;
import ar.edu.utn.frc.tup.lciii.models.exchange_rate.ExchangeRate;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CarsRestClient {
    RestTemplate restTemplate = new RestTemplate();
    String urlCar = "https://my-json-server.typicode.com/danielcattaneob/fake-apis/cars";

    private static final String RESILIENCE4J_INSTANCE_NAME = "microCircuitBreaker";
    private static final String FALLBACK_METHOD = "fallback";


    @Value("${exchange.rate.url}")
    String urlExchangeRates;
    public ResponseEntity<Cars> getCar(Long id){
        ResponseEntity<Cars> car = restTemplate.getForEntity(urlCar + "/" + id, Cars.class);
        return car;
    }

    public ResponseEntity<Cars[]> getAllCar(){
        ResponseEntity<Cars[]> lcar = restTemplate.getForEntity(urlCar, Cars[].class);
        return lcar;
    }

    @CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = FALLBACK_METHOD)
   public ResponseEntity<ExchangeRate> getExchangeRate( String currency){
        ResponseEntity<ExchangeRate> exchangeRate = restTemplate.getForEntity(urlExchangeRates+ "?currency=" + currency, ExchangeRate.class);
        if(exchangeRate.equals(null))
            throw new RuntimeException("no trajo nada");
        return exchangeRate;
    }

    //FALTA HACER ALGO EN EL SERVICE PARA QUE TE LO TRAIGA
    public ExchangeRate[] fallback(Exception ex) {
        ExchangeRate excha = new ExchangeRate("error", "error", BigDecimal.ONE);
        ExchangeRate[] exs = new ExchangeRate[]{excha};

        return exs;
    }
}
