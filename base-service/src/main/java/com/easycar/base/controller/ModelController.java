package com.easycar.base.controller;

import com.easycar.base.entity.Model;
import com.easycar.base.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/model")
public class ModelController {

    private final ModelService modelService;

    @GetMapping
    public List<Model> findAll() {
        return modelService.findAll();
    }

    @GetMapping("{id}")
    public Model findById(@PathVariable String id) {
        return modelService.findById(id);
    }
}
