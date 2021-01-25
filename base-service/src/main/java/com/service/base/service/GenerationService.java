package com.service.base.service;

import com.service.base.model.Generation;
import com.service.base.repository.GenerationRepo;
import com.service.base.repository.ModelRepo;
import com.service.base.util.ErrorLogUtil;
import com.service.base.util.ValidationUtil;
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
