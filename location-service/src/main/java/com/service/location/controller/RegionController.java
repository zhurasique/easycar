package com.service.location.controller;

import com.service.location.entity.Region;
import com.service.location.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/location-service/region")
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

    @PostMapping
    public Region save(@Valid @RequestBody Region region) {
        return regionService.save(region);
    }
}
