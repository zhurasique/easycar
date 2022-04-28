package com.service.base.controller;

import com.service.base.entity.Power;
import com.service.base.service.PowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/base-service/power")
public class PowerController {

    private final PowerService powerService;

    @GetMapping
    public List<Power> findAll() {
        return powerService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Power power) {
        return powerService.save(power);
    }
}
