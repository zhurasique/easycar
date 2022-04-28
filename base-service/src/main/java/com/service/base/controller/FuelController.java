package com.service.base.controller;

import com.service.base.entity.Fuel;
import com.service.base.service.FuelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/base-service/fuel")
public class FuelController {

    private final FuelService fuelService;

    @GetMapping
    public List<Fuel> findAll() {
        return fuelService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Fuel fuel) {
        return fuelService.save(fuel);
    }
}
