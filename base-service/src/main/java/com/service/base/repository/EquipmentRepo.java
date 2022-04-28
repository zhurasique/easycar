package com.service.base.repository;

import com.service.base.entity.Equipment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EquipmentRepo extends MongoRepository<Equipment, String> {
    Equipment findByName(String name);
}
