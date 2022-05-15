package com.service.location.repository;

import com.service.location.entity.Region;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegionRepo extends MongoRepository<Region, String> {
}
