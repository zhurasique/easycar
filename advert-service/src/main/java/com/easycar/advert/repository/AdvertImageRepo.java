package com.easycar.advert.repository;

import com.easycar.advert.entity.AdvertImage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AdvertImageRepo extends MongoRepository<AdvertImage, String> {
    List<AdvertImage> findByAdvertId(String id);
}
