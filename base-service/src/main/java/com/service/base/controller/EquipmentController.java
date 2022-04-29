package com.service.base.controller;

import com.service.base.entity.Equipment;
import com.service.base.service.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ResponseEntity<?> save(@Valid @RequestBody Equipment equipment) {
        return equipmentService.save(equipment);
    }
}
