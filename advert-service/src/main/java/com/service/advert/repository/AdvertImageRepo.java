package com.service.advert.repository;

import com.service.advert.model.AdvertImage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AdvertImageRepo extends MongoRepository<AdvertImage, String> {
    List<AdvertImage> findByAdvertId(String id);
}
