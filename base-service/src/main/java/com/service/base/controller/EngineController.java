package com.service.base.controller;

import com.service.base.entity.Engine;
import com.service.base.service.EngineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
