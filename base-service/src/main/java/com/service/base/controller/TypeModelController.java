package com.service.base.controller;

import com.service.base.entity.TypeModel;
import com.service.base.service.TypeModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/base-service/type-model")
public class TypeModelController {

    private final TypeModelService typeModelService;

    @GetMapping
    public List<TypeModel> findAll() {
        return typeModelService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody TypeModel typeModel) {
        return typeModelService.save(typeModel);
    }
}
