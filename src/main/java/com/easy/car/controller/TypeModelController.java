package com.easy.car.controller;

import com.easy.car.model.TypeModel;
import com.easy.car.service.TypeModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/type_model")
public class TypeModelController {

    private final TypeModelService typeModelService;

    @Autowired
    public TypeModelController(TypeModelService typeModelService) {
        this.typeModelService = typeModelService;
    }

    @GetMapping
    public List<TypeModel> findAll() {
        return typeModelService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody TypeModel typeModel) {
        return typeModelService.save(typeModel);
    }
}
