package com.easycar.base.service;

import com.easycar.base.entity.CarEquipment;
import com.easycar.base.repository.CarEquipmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarEquipmentService {

    private final CarEquipmentRepo carEquipmentRepo;
    private final CarService carService;
    private final EquipmentService equipmentService;

    public List<CarEquipment> findByCarId(String id) {
        return carEquipmentRepo.findByCarId(id);
    }

    public CarEquipment save(CarEquipment carEquipment) {
        carEquipment.setEquipment(equipmentService.findById(carEquipment.getEquipment().getId()));
        carEquipment.setCar(carService.findById(carEquipment.getCar().getId()));
        return carEquipmentRepo.save(carEquipment);
    }
}
