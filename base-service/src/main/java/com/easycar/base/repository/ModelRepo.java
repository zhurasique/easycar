package com.easycar.base.repository;

import com.easycar.base.entity.Model;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ModelRepo extends MongoRepository<Model, String> {
    Model findByName(String name);
}
