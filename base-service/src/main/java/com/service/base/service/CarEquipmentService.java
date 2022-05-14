package com.service.base.service;

import com.service.base.entity.CarEquipment;
import com.service.base.repository.CarEquipmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarEquipmentService {

    private final CarEquipmentRepo carEquipmentRepo;

    public List<CarEquipment> findByCarId(String id) {
        return carEquipmentRepo.findByCarId(id);
    }

    public CarEquipment save(CarEquipment carEquipment) {
        return carEquipmentRepo.save(carEquipment);
    }
}
