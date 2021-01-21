package com.easy.car.repository;

import com.easy.car.model.Brand;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BrandRepo extends MongoRepository<Brand, String> {
    Brand findByName(String name);
}
