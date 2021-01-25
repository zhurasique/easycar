package com.easy.car.service;

import com.easy.car.model.Equipment;
import com.easy.car.repository.EquipmentRepo;
import com.easy.car.util.ErrorLogUtil;
import com.easy.car.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {

    private final EquipmentRepo equipmentRepo;

    public EquipmentService(EquipmentRepo equipmentRepo) {
        this.equipmentRepo = equipmentRepo;
    }

    public List<Equipment> findAll() {
        return equipmentRepo.findAll();
    }

    public ResponseEntity<?> save(Equipment equipment) {

        if(!ValidationUtil.validateEquipmentName(equipment.getName(), equipmentRepo))
            return new ResponseEntity<>(ErrorLogUtil.showError(112), HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(equipmentRepo.save(equipment), HttpStatus.OK);
    }
}
