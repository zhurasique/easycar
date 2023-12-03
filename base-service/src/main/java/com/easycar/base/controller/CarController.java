package com.easycar.base.controller;

import com.easycar.base.entity.Car;
import com.easycar.base.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    @GetMapping("{id}")
    public Car findById(@PathVariable String id) {
        return carService.findById(id);
    }
}
