package com.service.base.repository;

import com.service.base.entity.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepo extends MongoRepository<Car, String> {
}
