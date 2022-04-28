package com.service.base.repository;

import com.service.base.entity.Type;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TypeRepo extends MongoRepository<Type, String> {
    Type findByName(String name);
}
