package com.service.base.controller;

import com.service.base.model.Color;
import com.service.base.service.ColorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/base-service/color")
public class ColorController {

    private final ColorService colorService;

    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @GetMapping
    public List<Color> findAll() {
        return colorService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Color color) {
        return colorService.save(color);
    }
}
