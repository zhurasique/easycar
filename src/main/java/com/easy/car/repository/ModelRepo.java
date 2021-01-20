package com.easy.car.repository;

import com.easy.car.model.Model;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ModelRepo extends MongoRepository<Model, String> {
    Model findByName(String name);
}
