package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.models.ExchangeRate;
import org.springframework.stereotype.Service;

@Service
public interface ExRateService {

    ExchangeRate getExchangeRate(String filter);
    ExchangeRate[] getExchangeRate();
    boolean saveExchangeRate();
}
