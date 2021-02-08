package com.service.image.repository;

import com.service.image.model.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepo extends MongoRepository<Image, String> {
}
