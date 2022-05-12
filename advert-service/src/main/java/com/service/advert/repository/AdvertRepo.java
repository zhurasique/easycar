package com.service.advert.repository;

import com.service.advert.entity.Advert;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdvertRepo extends MongoRepository<Advert, String> {
}
