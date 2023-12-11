package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.clients.CarsRestClient;
import ar.edu.utn.frc.tup.lciii.dtos.models.CarsDTO;
import ar.edu.utn.frc.tup.lciii.entities.CarEntity;
import ar.edu.utn.frc.tup.lciii.models.cars.Cars;
//import ar.edu.utn.frc.tup.lciii.models.exchange_rates.ExchangeRate;
import ar.edu.utn.frc.tup.lciii.models.exchange_rate.ExchangeRate;
import ar.edu.utn.frc.tup.lciii.repositories.CarJpaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarsRestClient carsRestClient;

    @Autowired
    private CarJpaRepository carJpaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CarsDTO getCar(Long id){
        BigDecimal localPrice = new BigDecimal(0);
        Cars car = carsRestClient.getCar(id).getBody();

        if(!car.getPrice().getCurrency().equals("ARS")){
            ExchangeRate cot = carsRestClient.getExchangeRate(car.getPrice().getCurrency()).getBody();
            localPrice = car.getPrice().getAmount().multiply(cot.exchange_rate());
        }
        else
            localPrice = car.getPrice().getAmount();

        CarsDTO carsDTO = new CarsDTO();
        carsDTO.setBrand(car.getBrand());
        carsDTO.setModel(car.getModel());
        carsDTO.setLocal_price(localPrice);
        return carsDTO;
    }

    public List<CarsDTO> getAllCars(){
        BigDecimal localPrice = new BigDecimal(0);
        Cars[] lcar = carsRestClient.getAllCar().getBody();
        List<CarsDTO> lCarsDTO = new ArrayList<>();

        for(Cars car : lcar){
            if(car.getPrice().getCurrency().equals("BRL")){
                localPrice = BigDecimal.valueOf(0);
            }else if(!car.getPrice().getCurrency().equals("ARS")){
                ExchangeRate cot = carsRestClient.getExchangeRate(car.getPrice().getCurrency()).getBody();
                localPrice = car.getPrice().getAmount().multiply(cot.exchange_rate());
            }
            else
                localPrice = car.getPrice().getAmount();

            CarsDTO carsDTO = new CarsDTO();
            carsDTO.setBrand(car.getBrand());
            carsDTO.setModel(car.getModel());
            carsDTO.setLocal_price(localPrice);
            lCarsDTO.add(carsDTO);
        }
        return lCarsDTO;
    }

    public boolean saveAllCars() {
        List<CarsDTO> lCarsDTO = getAllCars();
        boolean allSavedSuccessfully = true;

        for (CarsDTO carsDTO : lCarsDTO) {
            CarEntity entity = modelMapper.map(carsDTO, CarEntity.class);
            try {
                carJpaRepository.save(entity);
            } catch (Exception e) {
                allSavedSuccessfully = false;
            }
        }
        return allSavedSuccessfully;
    }

}
