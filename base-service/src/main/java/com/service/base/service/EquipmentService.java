package com.service.base.service;

import com.service.base.entity.Equipment;
import com.service.base.repository.EquipmentRepo;
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

    public Equipment save(Equipment equipment) {
        return equipmentRepo.save(equipment);
    }
}
