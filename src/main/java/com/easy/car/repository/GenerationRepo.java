package com.easy.car.repository;

import com.easy.car.model.Generation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GenerationRepo extends MongoRepository<Generation, String> {
}
