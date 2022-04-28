package com.service.base.controller;

import com.service.base.entity.TypeModel;
import com.service.base.service.TypeModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/base-service/type_model")
public class TypeModelController {

    private final TypeModelService typeModelService;

    @GetMapping
    public List<TypeModel> findAll() {
        return typeModelService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody TypeModel typeModel) throws Exception {
        return typeModelService.save(typeModel);
    }
}
