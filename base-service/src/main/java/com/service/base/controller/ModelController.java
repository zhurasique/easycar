package com.service.base.controller;

import com.service.base.model.Model;
import com.service.base.service.ModelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/base-service/model")
public class ModelController {

    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping
    public List<Model> findAll() {
        return modelService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Model model) throws Exception {
        return modelService.save(model);
    }
}
