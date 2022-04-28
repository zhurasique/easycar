package com.service.base.repository;

import com.service.base.entity.Generation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GenerationRepo extends MongoRepository<Generation, String> {
}
