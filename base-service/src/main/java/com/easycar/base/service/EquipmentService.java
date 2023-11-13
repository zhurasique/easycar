package com.easycar.base.service;

import com.easycar.common.exception.NoSuchElementFoundException;
import com.easycar.base.entity.Equipment;
import com.easycar.base.repository.EquipmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipmentService {

    private final EquipmentRepo equipmentRepo;

    public List<Equipment> findAll() {
        return equipmentRepo.findAll();
    }

    public Equipment findById(String id) {
        return equipmentRepo.findById(id).orElseThrow(() -> new NoSuchElementFoundException(id));
    }

    public Equipment save(Equipment equipment) {
        return equipmentRepo.save(equipment);
    }
}
