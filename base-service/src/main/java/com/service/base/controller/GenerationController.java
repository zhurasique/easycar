package com.service.base.controller;

import com.service.base.model.Generation;
import com.service.base.service.GenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/base-service/generation")
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
