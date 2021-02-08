package com.service.base.repository;

import com.service.base.model.Generation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GenerationRepo extends MongoRepository<Generation, String> {
}
