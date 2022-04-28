package com.service.base.service;

import com.service.base.entity.TypeModel;
import com.service.base.repository.TypeModelRepo;
import com.service.base.repository.ModelRepo;
import com.service.base.repository.TypeRepo;
import com.service.base.util.ErrorLogUtil;
import com.service.base.util.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeModelService {

    private final TypeModelRepo typeModelRepo;
    private final TypeRepo typeRepo;
    private final ModelRepo modelRepo;

    public List<TypeModel> findAll() {
        return typeModelRepo.findAll();
    }

    public ResponseEntity<?> save(TypeModel typeModel) throws Exception {

        if(!ValidationUtil.validateTypeModelType(typeModel.getType().getId(), typeRepo))
            return new ResponseEntity<>(ErrorLogUtil.showError(106), HttpStatus.BAD_REQUEST);

        if(!ValidationUtil.validateTypeModelModel(typeModel.getModel().getId(), modelRepo))
            return new ResponseEntity<>(ErrorLogUtil.showError(107), HttpStatus.BAD_REQUEST);
        typeModel.setModel(modelRepo.findById(typeModel.getModel().getId()).orElseThrow(Exception::new));

        if(!ValidationUtil.validateTypeModel(typeModel.getType(), typeModel.getModel(), typeModelRepo))
            return new ResponseEntity<>(ErrorLogUtil.showError(108), HttpStatus.BAD_REQUEST);
        typeModel.setType(typeRepo.findById(typeModel.getType().getId()).orElseThrow(Exception::new));

        return new ResponseEntity<>(typeModelRepo.save(typeModel), HttpStatus.OK);
    }
}
