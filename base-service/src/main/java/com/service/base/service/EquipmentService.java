package com.service.base.service;

import com.service.base.entity.Equipment;
import com.service.base.repository.EquipmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipmentService {

    private final EquipmentRepo equipmentRepo;

    public List<Equipment> findAll() {
        return equipmentRepo.findAll();
    }

    public ResponseEntity<?> save(Equipment equipment) {
        return new ResponseEntity<>(equipmentRepo.save(equipment), HttpStatus.OK);
    }
}
