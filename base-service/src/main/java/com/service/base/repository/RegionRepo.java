package com.service.base.repository;

import com.service.base.entity.Region;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegionRepo extends MongoRepository<Region, String> {
}
