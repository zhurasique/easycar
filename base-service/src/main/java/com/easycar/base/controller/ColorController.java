package com.easycar.base.controller;

import com.easycar.base.entity.Color;
import com.easycar.base.service.ColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/color")
public class ColorController {

    private final ColorService colorService;

    @GetMapping
    public List<Color> findAll() {
        return colorService.findAll();
    }

    @GetMapping("{id}")
    public Color findById(@PathVariable("id") String id) {
        return colorService.findById(id);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Color save(@Valid @RequestBody Color color) {
        return colorService.save(color);
    }
}
