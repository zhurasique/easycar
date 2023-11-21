package com.easycar.base.controller;

import com.easycar.base.entity.Type;
import com.easycar.base.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/type")
public class TypeController {

    private final TypeService typeService;

    @GetMapping
    public List<Type> findAll() {
        return typeService.findAll();
    }

    @GetMapping("{id}")
    public Type findById(@PathVariable String id) {
        return typeService.findById(id);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Type save(@Valid Type.Dto type) throws IOException {
        return typeService.save(type);
    }
}
