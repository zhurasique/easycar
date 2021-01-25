package com.easy.car.controller;

import com.easy.car.model.Equipment;
import com.easy.car.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/equipments")
public class EquipmentController {

    private final EquipmentService equipmentService;

    @Autowired
    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping
    public List<Equipment> findAll() {
        return equipmentService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Equipment equipment) {
        return equipmentService.save(equipment);
    }
}
