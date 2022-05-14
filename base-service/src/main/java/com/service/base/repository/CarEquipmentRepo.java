package com.service.base.repository;

import com.service.base.entity.Car;
import com.service.base.entity.CarEquipment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CarEquipmentRepo extends MongoRepository<CarEquipment, String> {
    List<CarEquipment> findByCarId(String id);
}
