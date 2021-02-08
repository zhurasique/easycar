package com.service.base.service;

import com.service.base.model.Model;
import com.service.base.repository.BrandRepo;
import com.service.base.repository.ModelRepo;
import com.service.base.util.ErrorLogUtil;
import com.service.base.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {

    private final ModelRepo modelRepo;
    private final BrandRepo brandRepo;

    public ModelService(ModelRepo modelRepo, BrandRepo brandRepo) {
        this.modelRepo = modelRepo;
        this.brandRepo = brandRepo;
    }

    public List<Model> findAll(){
        return modelRepo.findAll();
    }

    public ResponseEntity<?> save(Model model) throws Exception {

        if(!ValidationUtil.validateModelName(model.getName(), modelRepo))
            return new ResponseEntity<>(ErrorLogUtil.showError(104), HttpStatus.BAD_REQUEST);

        if(!ValidationUtil.validateModelBrand(model.getBrand().getId(), brandRepo))
            return new ResponseEntity<>(ErrorLogUtil.showError(105), HttpStatus.BAD_REQUEST);
        model.setBrand(brandRepo.findById(model.getBrand().getId()).orElseThrow(Exception::new));

        return new ResponseEntity<>(modelRepo.save(model), HttpStatus.OK);
    }
}
