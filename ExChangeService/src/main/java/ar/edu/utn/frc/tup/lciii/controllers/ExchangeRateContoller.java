package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.models.ExchangeRate;
import ar.edu.utn.frc.tup.lciii.services.ExRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("ExRate")
public class ExchangeRateContoller {

    @Autowired
    private ExRateService exRateService;

    @GetMapping("/getExRate")
    public ResponseEntity<ExchangeRate[]> getExRateByFrom(){
        return ResponseEntity.ok(exRateService.getExchangeRate());
    }

    @GetMapping("/getExRateFrom")
    public ResponseEntity<ExchangeRate> getExRateByFrom(@RequestParam String currency){
        return ResponseEntity.ok(exRateService.getExchangeRate(currency));
    }

    @PostMapping("/saveAllExchangeRate")
    public ResponseEntity<Boolean> saveAllExRate(){
        return ResponseEntity.ok(exRateService.saveExchangeRate());
    }

}
