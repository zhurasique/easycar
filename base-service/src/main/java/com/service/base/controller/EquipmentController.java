package com.service.base.controller;

import com.service.base.entity.Equipment;
import com.service.base.service.EquipmentService;
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
@RequestMapping("api/base-service/equipment")
public class EquipmentController {

    private final EquipmentService equipmentService;

    @GetMapping
    public List<Equipment> findAll() {
        return equipmentService.findAll();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Equipment save(@Valid @RequestBody Equipment equipment) {
        return equipmentService.save(equipment);
    }
}
