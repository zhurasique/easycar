package com.easy.car.service;

import com.easy.car.model.Model;
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

    public ModelService(ModelRepo modelRepo) {
        this.modelRepo = modelRepo;
    }

    public List<Model> findAll(){
        return modelRepo.findAll();
    }

    public ResponseEntity<?> save(String name, String imageUrl) {

//        if(!ValidationUtil.validateModelName(name, modelRepo))
//            return new ResponseEntity<>(ErrorLogUtil.showError(103), HttpStatus.BAD_REQUEST);

        Model model = new Model();

        model.setName(name);
        model.setImageUrl(imageUrl);

        return new ResponseEntity<>(modelRepo.save(model), HttpStatus.OK);
    }
}
