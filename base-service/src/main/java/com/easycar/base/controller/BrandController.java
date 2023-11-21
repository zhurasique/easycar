package com.easycar.base.controller;

import com.easycar.base.entity.Brand;
import com.easycar.base.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/brand")
public class BrandController {

    private final BrandService brandService;

    @GetMapping
    public List<Brand> findAll() {
        return brandService.findAll();
    }

    @GetMapping("{id}")
    public Brand findById(@PathVariable("id") String id) {
        return brandService.findById(id);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Brand save(@Valid Brand.Dto brand) throws IOException {
        return brandService.save(brand);
    }
}