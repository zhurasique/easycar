package com.easy.car.controller;

import com.easy.car.model.Generation;
import com.easy.car.service.GenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/generations")
public class GenerationController {

    private final GenerationService generationService;

    @Autowired
    public GenerationController(GenerationService generationService) {
        this.generationService = generationService;
    }

    @GetMapping
    public List<Generation> findAll() {
        return generationService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Generation generation) throws Exception {
        return generationService.save(generation);
    }
}
