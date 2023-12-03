package com.easycar.base.controller;

import com.easycar.base.entity.CarEquipment;
import com.easycar.base.service.CarEquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car-equipment")
public class CarEquipmentController {

    private final CarEquipmentService carEquipmentService;

    @GetMapping("/car/{id}")
    public List<CarEquipment> findByCarId(@PathVariable String id) {
        return carEquipmentService.findByCarId(id);
    }
}
