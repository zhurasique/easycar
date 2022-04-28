package com.service.base.service;

import com.service.base.entity.Generation;
import com.service.base.repository.GenerationRepo;
import com.service.base.repository.ModelRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenerationService {

    private final GenerationRepo generationRepo;
    private final ModelRepo modelRepo;

    public List<Generation> findAll() {
        return generationRepo.findAll();
    }

    public ResponseEntity<?> save(Generation generation) {
        generation.setModel(modelRepo.findById(generation.getModel().getId()).orElse(null));
        return new ResponseEntity<>(generationRepo.save(generation), HttpStatus.OK);
    }
}
