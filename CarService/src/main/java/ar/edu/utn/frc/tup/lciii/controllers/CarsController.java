package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.dtos.models.CarsDTO;
import ar.edu.utn.frc.tup.lciii.models.exchange_rate.ExchangeRate;
import ar.edu.utn.frc.tup.lciii.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("cars")
public class CarsController {

    @Autowired
    private CarService carService;

    @GetMapping("/getCarById/{id}")
    public ResponseEntity<CarsDTO> getCarById(@PathVariable Long id){
        return ResponseEntity.ok(carService.getCar(id));
    }

    @GetMapping("/getAllCars")
    public ResponseEntity<List<CarsDTO>> getCarById(){
        return ResponseEntity.ok(carService.getAllCars());
    }

    @PostMapping("/saveAllCars")
    public boolean saveAllCars(){
        return carService.saveAllCars();
    }

}
