package com.service.base.service;

import com.service.base.entity.Generation;
import com.service.base.exception.NoSuchElementFoundException;
import com.service.base.repository.GenerationRepo;
import com.service.base.repository.ModelRepo;
import lombok.RequiredArgsConstructor;
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

    public Generation save(Generation generation) {
        String modelId = generation.getModel().getId();
        generation.setModel(modelRepo.findById(modelId).orElseThrow(() -> new NoSuchElementFoundException(modelId)));
        return generationRepo.save(generation);
    }
}
