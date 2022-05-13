package com.service.base.service;

import com.service.base.entity.TypeModel;
import com.service.base.exception.NoSuchElementFoundException;
import com.service.base.repository.TypeModelRepo;
import com.service.base.repository.ModelRepo;
import com.service.base.repository.TypeRepo;
import lombok.RequiredArgsConstructor;
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

    public TypeModel save(TypeModel typeModel) {
        String modelId = typeModel.getModel().getId();
        typeModel.setModel(modelRepo.findById(modelId).orElseThrow(() -> new NoSuchElementFoundException(modelId)));
        String typeId = typeModel.getType().getId();
        typeModel.setType(typeRepo.findById(typeId).orElseThrow(() -> new NoSuchElementFoundException(typeId)));
        return typeModelRepo.save(typeModel);
    }
}
