package com.easycar.base.repository;

import com.easycar.base.entity.Generation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GenerationRepo extends MongoRepository<Generation, String> {
}
