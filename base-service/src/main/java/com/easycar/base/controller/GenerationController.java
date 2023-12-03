package com.easycar.base.controller;

import com.easycar.base.entity.Generation;
import com.easycar.base.service.GenerationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/generation")
public class GenerationController {

    private final GenerationService generationService;

    @GetMapping
    public List<Generation> findAll() {
        return generationService.findAll();
    }

    @GetMapping("{id}")
    public Generation findById(@PathVariable String id) {
        return generationService.findById(id);
    }
}
