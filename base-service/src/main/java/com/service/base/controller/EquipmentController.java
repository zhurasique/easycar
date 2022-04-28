package com.service.base.controller;

import com.service.base.entity.Equipment;
import com.service.base.service.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> save(@RequestBody Equipment equipment) {
        return equipmentService.save(equipment);
    }
}
