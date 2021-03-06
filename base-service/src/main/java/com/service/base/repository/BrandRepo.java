package com.service.base.repository;

import com.service.base.model.Brand;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BrandRepo extends MongoRepository<Brand, String> {
    Brand findByName(String name);
}
