package com.service.base.controller;

import com.service.base.model.Engine;
import com.service.base.service.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/base-service/engine")
public class EngineController {

    private final EngineService engineService;

    @Autowired
    public EngineController(EngineService engineService) {
        this.engineService = engineService;
    }

    @GetMapping
    public List<Engine> findAll() {
        return engineService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Engine engine) {
        return engineService.save(engine);
    }
}
