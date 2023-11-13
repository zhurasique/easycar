package com.easycar.base.repository;

import com.easycar.base.entity.Equipment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EquipmentRepo extends MongoRepository<Equipment, String> {
    Equipment findByName(String name);
}
