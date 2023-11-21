package com.easycar.base.controller;

import com.easycar.base.entity.Car;
import com.easycar.base.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    @GetMapping("{id}")
    public Car findById(@PathVariable String id) {
        return carService.findById(id);
    }

    @PutMapping("{id}")
    public Car update(@PathVariable String id, @Valid @RequestBody Car newData) {
        return carService.update(id, newData);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        carService.delete(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Car save(@Valid @RequestBody Car car) {
        return carService.save(car);
    }
}
