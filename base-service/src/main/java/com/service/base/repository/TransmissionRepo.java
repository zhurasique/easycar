package com.service.base.repository;

import com.service.base.model.Transmission;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransmissionRepo extends MongoRepository<Transmission, String> {
    Transmission findByName(String name);
}
