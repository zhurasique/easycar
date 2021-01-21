package com.easy.car.service;

import com.easy.car.model.TypeModel;
import com.easy.car.repository.ModelRepo;
import com.easy.car.repository.TypeModelRepo;
import com.easy.car.repository.TypeRepo;
import com.easy.car.util.ErrorLogUtil;
import com.easy.car.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeModelService {

    private final TypeModelRepo typeModelRepo;
    private final TypeRepo typeRepo;
    private final ModelRepo modelRepo;

    public TypeModelService(TypeModelRepo typeModelRepo, TypeRepo typeRepo, ModelRepo modelRepo) {
        this.typeModelRepo = typeModelRepo;
        this.typeRepo = typeRepo;
        this.modelRepo = modelRepo;
    }

    public List<TypeModel> findAll() {
        return typeModelRepo.findAll();
    }

    public ResponseEntity<?> save(TypeModel typeModel) {

        if(!ValidationUtil.validateTypeModelType(typeModel.getType().getId(), typeRepo))
            return new ResponseEntity<>(ErrorLogUtil.showError(106), HttpStatus.BAD_REQUEST);

        if(!ValidationUtil.validateTypeModelModel(typeModel.getModel().getId(), modelRepo))
            return new ResponseEntity<>(ErrorLogUtil.showError(107), HttpStatus.BAD_REQUEST);

        if(!ValidationUtil.validateTypeModel(typeModel.getType(), typeModel.getModel(), typeModelRepo))
            return new ResponseEntity<>(ErrorLogUtil.showError(108), HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(typeModelRepo.save(typeModel), HttpStatus.OK);
    }
}
