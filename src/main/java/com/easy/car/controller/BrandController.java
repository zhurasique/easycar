package com.easy.car.controller;

import com.easy.car.model.Brand;
import com.easy.car.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandController {

    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public List<Brand> findAll() {
        return brandService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Brand brand) {
        return brandService.save(brand.getName(), brand.getImageUrl());
    }
}
