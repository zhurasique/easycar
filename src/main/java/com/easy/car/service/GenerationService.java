package com.easy.car.service;

import com.easy.car.model.Generation;
import com.easy.car.repository.GenerationRepo;
import com.easy.car.repository.ModelRepo;
import com.easy.car.util.ErrorLogUtil;
import com.easy.car.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenerationService {

    private final GenerationRepo generationRepo;
    private final ModelRepo modelRepo;

    public GenerationService(GenerationRepo generationRepo, ModelRepo modelRepo) {
        this.generationRepo = generationRepo;
        this.modelRepo = modelRepo;
    }

    public List<Generation> findAll() {
        return generationRepo.findAll();
    }

    public ResponseEntity<?> save(Generation generation) throws Exception {

        if(!ValidationUtil.validateGenerationName(generation.getName()))
            return new ResponseEntity<>(ErrorLogUtil.showError(109), HttpStatus.BAD_REQUEST);

        if(!ValidationUtil.validateGenerationYears(generation.getYearFrom(), generation.getYearTo()))
            return new ResponseEntity<>(ErrorLogUtil.showError(110), HttpStatus.BAD_REQUEST);

        if(!ValidationUtil.validateGenerationModel(generation.getModel().getId(), modelRepo))
            return new ResponseEntity<>(ErrorLogUtil.showError(111), HttpStatus.BAD_REQUEST);
        generation.setModel(modelRepo.findById(generation.getModel().getId()).orElseThrow(Exception::new));

        return new ResponseEntity<>(generationRepo.save(generation), HttpStatus.OK);
    }
}
