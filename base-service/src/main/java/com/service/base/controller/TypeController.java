package com.service.base.controller;

import com.service.base.entity.Type;
import com.service.base.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/base-service/type")
public class TypeController {

    private final TypeService typeService;

    @GetMapping
    public List<Type> findAll() {
        return typeService.findAll();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Type save(@Valid Type.Dto type) throws IOException {
        return typeService.save(type);
    }
}
