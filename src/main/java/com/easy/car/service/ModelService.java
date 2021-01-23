package com.easy.car.service;

import com.easy.car.model.Model;
import com.easy.car.repository.BrandRepo;
import com.easy.car.repository.ModelRepo;
import com.easy.car.util.ErrorLogUtil;
import com.easy.car.util.ValidationUtil;
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
