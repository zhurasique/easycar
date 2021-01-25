package com.service.base.service;

import com.service.base.model.Type;
import com.service.base.repository.TypeRepo;
import com.service.base.util.ErrorLogUtil;
import com.service.base.util.ValidationUtil;
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
