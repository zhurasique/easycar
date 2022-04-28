package com.service.base.repository;

import com.service.base.entity.Color;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ColorRepo extends MongoRepository<Color, String> {
    Color findByColor(String color);
    Color findByPattern(String pattern);
}
