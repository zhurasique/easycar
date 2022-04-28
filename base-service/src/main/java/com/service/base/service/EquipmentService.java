package com.service.base.service;

import com.service.base.entity.Equipment;
import com.service.base.repository.EquipmentRepo;
import com.service.base.util.ErrorLogUtil;
import com.service.base.util.ValidationUtil;
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

        if(!ValidationUtil.validateEquipmentName(equipment.getName(), equipmentRepo))
            return new ResponseEntity<>(ErrorLogUtil.showError(112), HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(equipmentRepo.save(equipment), HttpStatus.OK);
    }
}
