package com.easy.car.service;

import com.easy.car.model.Type;
import com.easy.car.repository.TypeRepo;
import com.easy.car.util.ErrorLogUtil;
import com.easy.car.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    private final TypeRepo typeRepo;

    public TypeService(TypeRepo typeRepo) {
        this.typeRepo = typeRepo;
    }

    public List<Type> findAll() {
        return typeRepo.findAll();
    }

    public ResponseEntity<?> save(Type type) {
        if(!ValidationUtil.validateTypeName(type.getName(), typeRepo))
            return new ResponseEntity<>(ErrorLogUtil.showError(101), HttpStatus.BAD_REQUEST);

        if(!ValidationUtil.validateTypeImageUrl(type.getImageUrl(), typeRepo))
            return new ResponseEntity<>(ErrorLogUtil.showError(102), HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(typeRepo.save(type), HttpStatus.OK);
    }
}
