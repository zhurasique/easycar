package com.easy.car.controller;

import com.easy.car.model.Type;
import com.easy.car.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/types")
public class TypeController {

    private final TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping
    public List<Type> findAll() {
        return typeService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Type type) {
        return typeService.save(type);
    }
}
