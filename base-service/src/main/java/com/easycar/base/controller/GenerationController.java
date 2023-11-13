package com.easycar.base.controller;

import com.easycar.base.entity.Generation;
import com.easycar.base.service.GenerationService;
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
@RequestMapping("api/base-service/generation")
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

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Generation save(@Valid @RequestBody Generation generation) {
        return generationService.save(generation);
    }
}
