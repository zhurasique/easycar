package com.easycar.base.controller;

import com.easycar.base.entity.Region;
import com.easycar.base.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/region")
public class RegionController {

    private final RegionService regionService;

    @GetMapping
    public List<Region> findAll() {
        return regionService.findAll();
    }

    @GetMapping("{id}")
    public Region findById(@PathVariable String id) {
        return regionService.findById(id);
    }
}
