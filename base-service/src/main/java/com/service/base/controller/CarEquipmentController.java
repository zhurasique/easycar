package com.service.base.controller;

import com.service.base.entity.CarEquipment;
import com.service.base.service.CarEquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/base-service/car-equipment")
public class CarEquipmentController {

    private final CarEquipmentService carEquipmentService;

    @GetMapping("/car/{id}")
    public List<CarEquipment> findByCarId(@PathVariable String id) {
        return carEquipmentService.findByCarId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarEquipment save(@Valid @RequestBody CarEquipment carEquipment) {
        return carEquipmentService.save(carEquipment);
    }
}
