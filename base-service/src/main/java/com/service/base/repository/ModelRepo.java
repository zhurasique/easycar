package com.service.base.repository;

import com.service.base.model.Model;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ModelRepo extends MongoRepository<Model, String> {
    Model findByName(String name);
}
