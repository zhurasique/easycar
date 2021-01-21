package com.easy.car.repository;

import com.easy.car.model.Model;
import com.easy.car.model.Type;
import com.easy.car.model.TypeModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TypeModelRepo extends MongoRepository<TypeModel, String> {
    List<TypeModel> findByTypeInAndModelIn(Type type, Model model);
}
