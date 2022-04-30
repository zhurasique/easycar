package com.service.base.service;

import com.service.base.entity.Model;
import com.service.base.repository.BrandRepo;
import com.service.base.repository.ModelRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelService {

    private final ModelRepo modelRepo;
    private final BrandRepo brandRepo;

    public List<Model> findAll(){
        return modelRepo.findAll();
    }

    public Model save(Model model) {
        model.setBrand(brandRepo.findById(model.getBrand().getId()).orElse(null));
        return modelRepo.save(model);
    }
}
