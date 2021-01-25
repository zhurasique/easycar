package com.easy.car.repository;

import com.easy.car.model.Equipment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EquipmentRepo extends MongoRepository<Equipment, String> {
    Equipment findByName(String name);
}
