package com.service.base.service;

import com.service.base.entity.TypeModel;
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
        typeModel.setModel(modelRepo.findById(typeModel.getModel().getId()).orElse(null));
        typeModel.setType(typeRepo.findById(typeModel.getType().getId()).orElse(null));
        return typeModelRepo.save(typeModel);
    }
}
