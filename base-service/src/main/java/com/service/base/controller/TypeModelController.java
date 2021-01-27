package com.service.base.controller;

import com.service.base.model.TypeModel;
import com.service.base.service.TypeModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/base-service/type_model")
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
    public ResponseEntity<?> save(@RequestBody TypeModel typeModel) throws Exception {
        return typeModelService.save(typeModel);
    }
}
