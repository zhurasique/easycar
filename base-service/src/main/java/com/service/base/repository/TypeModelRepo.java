package com.service.base.repository;

import com.service.base.model.Model;
import com.service.base.model.Type;
import com.service.base.model.TypeModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TypeModelRepo extends MongoRepository<TypeModel, String> {
    List<TypeModel> findByTypeInAndModelIn(Type type, Model model);
}
