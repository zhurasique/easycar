package com.easycar.image.repository;

import com.easycar.image.entity.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepo extends MongoRepository<Image, String> {
}
