package com.service.base.controller;

import com.service.base.entity.Color;
import com.service.base.service.ColorService;
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
@RequestMapping("api/base-service/color")
public class ColorController {

    private final ColorService colorService;

    @GetMapping
    public List<Color> findAll() {
        return colorService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Color color) {
        return colorService.save(color);
    }
}
