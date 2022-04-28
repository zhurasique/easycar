package com.service.base.controller;

import com.service.base.entity.Color;
import com.service.base.service.ColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/base-service/color")
public class ColorController {

    private final ColorService colorService;

    @GetMapping
    public List<Color> findAll() {
        return colorService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Color color) {
        return colorService.save(color);
    }
}
