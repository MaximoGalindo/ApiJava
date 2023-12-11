package ar.edu.utn.frc.tup.lciii.clients;

import ar.edu.utn.frc.tup.lciii.models.ExchangeRate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExRateRestClient {
    RestTemplate restTemplate = new RestTemplate();
    String urlExchangeRates = "https://my-json-server.typicode.com/danielcattaneob/fake-apis/exchange_rates";
   public ResponseEntity<ExchangeRate[]> getExchangeRate(String filter){
        ResponseEntity<ExchangeRate[]> exchangeRate = restTemplate.getForEntity(
                urlExchangeRates + filter, ExchangeRate[].class);
        return exchangeRate;
   }
    public ResponseEntity<ExchangeRate[]> getExchangeRate(){
        ResponseEntity<ExchangeRate[]> allExchangeRate = restTemplate.getForEntity(
                urlExchangeRates, ExchangeRate[].class);
        return ResponseEntity.ok(allExchangeRate.getBody());
    }
}
