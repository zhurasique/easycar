package com.easy.car.controller;

import com.easy.car.model.Model;
import com.easy.car.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/models")
public class ModelController {

    private final ModelService modelService;

    @Autowired
    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping
    public List<Model> findAll() {
        return modelService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Model model) {
        return modelService.save(model.getName(), model.getImageUrl());
    }
}
