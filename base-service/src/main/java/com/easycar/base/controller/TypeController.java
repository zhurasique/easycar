package com.easycar.base.controller;

import com.easycar.base.entity.Type;
import com.easycar.base.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
