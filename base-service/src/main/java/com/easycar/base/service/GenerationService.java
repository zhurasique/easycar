package com.easycar.base.service;

import com.easycar.common.exception.NoSuchElementFoundException;
import com.easycar.base.entity.Generation;
import com.easycar.base.repository.GenerationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenerationService {

    private final GenerationRepo generationRepo;
    private final ModelService modelService;

    public List<Generation> findAll() {
        return generationRepo.findAll();
    }

    public Generation findById(String id) {
        return generationRepo.findById(id).orElseThrow(() -> new NoSuchElementFoundException(id));
    }

    public Generation save(Generation generation) {
        generation.setModel(modelService.findById(generation.getModel().getId()));
        return generationRepo.save(generation);
    }
}
