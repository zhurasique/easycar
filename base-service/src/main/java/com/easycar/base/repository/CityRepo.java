package com.easycar.base.repository;

import com.easycar.base.entity.City;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CityRepo extends MongoRepository<City, String> {
    List<City> findByRegionId(String id);
}
