package com.service.base.repository;

import com.service.base.entity.Model;
import com.service.base.entity.Type;
import com.service.base.entity.TypeModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TypeModelRepo extends MongoRepository<TypeModel, String> {
    List<TypeModel> findByTypeInAndModelIn(Type type, Model model);
}
