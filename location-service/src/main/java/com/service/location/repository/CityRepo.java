package com.service.location.repository;

import com.service.location.entity.City;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CityRepo extends MongoRepository<City, String> {
    List<City> findByRegionId(String id);
}
