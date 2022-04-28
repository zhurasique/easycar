package com.service.base.controller;

import com.service.base.entity.Generation;
import com.service.base.service.GenerationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/base-service/generation")
public class GenerationController {

    private final GenerationService generationService;

    @GetMapping
    public List<Generation> findAll() {
        return generationService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Generation generation) throws Exception {
        return generationService.save(generation);
    }
}
