package com.service.base.repository;

import com.service.base.entity.Power;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PowerRepo extends MongoRepository<Power, String> {
    Power findByPower(int power);
}
