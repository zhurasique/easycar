package com.service.base.controller;

import com.service.base.model.Fuel;
import com.service.base.service.FuelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/base-service/fuel")
public class FuelController {

    private final FuelService fuelService;

    public FuelController(FuelService fuelService) {
        this.fuelService = fuelService;
    }

    @GetMapping
    public List<Fuel> findAll() {
        return fuelService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Fuel fuel) {
        return fuelService.save(fuel);
    }
}
