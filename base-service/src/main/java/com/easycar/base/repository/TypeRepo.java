package com.easycar.base.repository;

import com.easycar.base.entity.Type;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TypeRepo extends MongoRepository<Type, String> {
    Type findByName(String name);
}
