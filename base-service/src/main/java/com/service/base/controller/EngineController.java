package com.service.base.controller;

import com.service.base.entity.Engine;
import com.service.base.service.EngineService;
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
@RequestMapping("api/base-service/engine")
public class EngineController {

    private final EngineService engineService;

    @GetMapping
    public List<Engine> findAll() {
        return engineService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Engine engine) {
        return engineService.save(engine);
    }
}
