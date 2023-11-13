package com.easycar.base.repository;

import com.easycar.base.entity.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepo extends MongoRepository<Car, String> {
}
