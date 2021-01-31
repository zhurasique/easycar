package com.service.base.repository;

import com.service.base.model.Fuel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FuelRepo extends MongoRepository<Fuel, String> {
    Fuel findByName(String name);
}
