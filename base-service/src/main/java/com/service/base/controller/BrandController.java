package com.service.base.controller;

import com.service.base.model.Brand;
import com.service.base.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @GetMapping("{id}")
    public Brand findById(@PathVariable("id") String id) throws Exception {
        return brandService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Brand brand, MultipartFile multipartFile) {
        return brandService.save(brand, multipartFile);
    }
}