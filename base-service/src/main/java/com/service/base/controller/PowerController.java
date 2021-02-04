package com.service.base.controller;

import com.service.base.model.Power;
import com.service.base.service.PowerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/base-service/power")
public class PowerController {

    private final PowerService powerService;

    public PowerController(PowerService powerService) {
        this.powerService = powerService;
    }

    @GetMapping
    public List<Power> findAll() {
        return powerService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Power power) {
        return powerService.save(power);
    }
}
