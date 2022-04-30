package com.service.base.controller;

import com.service.base.entity.Fuel;
import com.service.base.service.FuelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    @ResponseStatus(value = HttpStatus.CREATED)
    public Fuel save(@Valid @RequestBody Fuel fuel) {
        return fuelService.save(fuel);
    }
}
