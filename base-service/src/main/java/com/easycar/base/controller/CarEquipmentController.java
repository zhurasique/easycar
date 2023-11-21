package com.easycar.base.controller;

import com.easycar.base.entity.CarEquipment;
import com.easycar.base.service.CarEquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/car-equipment")
public class CarEquipmentController {

    private final CarEquipmentService carEquipmentService;

    @GetMapping("/car/{id}")
    public List<CarEquipment> findByCarId(@PathVariable String id) {
        return carEquipmentService.findByCarId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public CarEquipment save(@Valid @RequestBody CarEquipment carEquipment) {
        return carEquipmentService.save(carEquipment);
    }
}
