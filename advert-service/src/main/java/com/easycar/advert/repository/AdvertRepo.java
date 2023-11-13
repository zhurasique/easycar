package com.easycar.advert.repository;

import com.easycar.advert.entity.Advert;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdvertRepo extends MongoRepository<Advert, String> {
}
