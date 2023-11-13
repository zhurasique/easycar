package com.easycar.base.repository;

import com.easycar.base.entity.Location;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LocationRepo extends MongoRepository<Location, String> {
    List<Location> findByCityId(String id);
}
