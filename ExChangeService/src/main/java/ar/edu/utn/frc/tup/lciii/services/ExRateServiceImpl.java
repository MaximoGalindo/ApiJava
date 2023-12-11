package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.clients.ExRateRestClient;
import ar.edu.utn.frc.tup.lciii.entities.ExchangeRateEntity;
import ar.edu.utn.frc.tup.lciii.models.ExchangeRate;
import ar.edu.utn.frc.tup.lciii.repositories.ExchangeRateJpaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExRateServiceImpl implements ExRateService {

    @Autowired
    private ExRateRestClient exRateRestClient;

    @Autowired
    private ExchangeRateJpaRepository exchangeRateJpaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ExchangeRate getExchangeRate(String currencyFrom) {
        ExchangeRate[] cot = exRateRestClient.getExchangeRate("?from=" + currencyFrom).getBody();
        return cot[0];
    }

    @Override
    public ExchangeRate[] getExchangeRate() {
        ExchangeRate[] exR = exRateRestClient.getExchangeRate().getBody();
        return exR;
    }

    @Override
    public boolean saveExchangeRate() {
        ExchangeRate[] lExchangeRate = getExchangeRate();
        boolean allSavedSuccessfully = true;

        for (ExchangeRate exchangeRate : lExchangeRate) {
            ExchangeRateEntity entity = modelMapper.map(exchangeRate, ExchangeRateEntity.class);
            try {
                exchangeRateJpaRepository.save(entity);
            } catch (Exception e) {
                allSavedSuccessfully = false;
            }
        }

        return allSavedSuccessfully;
    }

}
