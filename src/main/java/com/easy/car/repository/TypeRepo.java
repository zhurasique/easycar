package com.easy.car.repository;

import com.easy.car.model.Type;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TypeRepo extends MongoRepository<Type, String> {
    Type findByName(String name);
    Type findByImageUrl(String imageUrl);
}
