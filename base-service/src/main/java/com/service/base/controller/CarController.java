package com.service.base.controller;

import com.service.base.entity.Car;
import com.service.base.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/base-service/car")
public class CarController {

    private final CarService carService;

    @GetMapping("{id}")
    public Car findById(@PathVariable String id) {
        return carService.findById(id);
    }

    @PostMapping
    public Car save(@Valid @RequestBody Car car) {
        return carService.save(car);
    }
}
