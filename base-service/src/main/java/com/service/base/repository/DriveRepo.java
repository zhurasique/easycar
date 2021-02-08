package com.service.base.repository;

import com.service.base.model.Drive;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DriveRepo extends MongoRepository<Drive, String> {
    Drive findByName(String name);
}
