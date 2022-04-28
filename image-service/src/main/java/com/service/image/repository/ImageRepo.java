package com.service.image.repository;

import com.service.image.entity.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepo extends MongoRepository<Image, String> {
}
