package com.service.base.repository;

import com.service.base.model.Engine;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EngineRepo extends MongoRepository<Engine, String> {
    Engine findByCapacity(int capacity);
}
