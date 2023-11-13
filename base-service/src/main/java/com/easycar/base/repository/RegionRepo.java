package com.easycar.base.repository;

import com.easycar.base.entity.Region;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegionRepo extends MongoRepository<Region, String> {
}
