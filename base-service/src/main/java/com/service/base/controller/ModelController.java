package com.service.base.controller;

import com.service.base.entity.Model;
import com.service.base.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/base-service/model")
public class ModelController {

    private final ModelService modelService;

    @GetMapping
    public List<Model> findAll() {
        return modelService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Model model) throws Exception {
        return modelService.save(model);
    }
}
