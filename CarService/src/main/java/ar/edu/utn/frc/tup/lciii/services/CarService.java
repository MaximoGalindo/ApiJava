package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.dtos.models.CarsDTO;

import java.util.Date;
import java.util.List;

public interface CarService {

    CarsDTO getCar(Long id);
    List<CarsDTO> getAllCars();
    boolean saveAllCars();

}
