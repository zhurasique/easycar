package com.service.base.controller;

import com.service.base.entity.Model;
import com.service.base.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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

    @GetMapping("{id}")
    public Model findById(@PathVariable String id) {
        return modelService.findById(id);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Model save(@Valid @RequestBody Model model) {
        return modelService.save(model);
    }
}
