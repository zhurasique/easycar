package com.service.base.controller;

import com.service.base.entity.Brand;
import com.service.base.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/base-service/brand")
public class BrandController {

    private final BrandService brandService;

    @GetMapping
    public List<Brand> findAll() {
        return brandService.findAll();
    }

    @GetMapping("{id}")
    public Brand findById(@PathVariable("id") String id) throws Exception {
        return brandService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestPart(name = "name") String name,
                                  @RequestPart(name = "image") MultipartFile image)
            throws IOException, JSONException {
        return brandService.save(name, image);
    }
}
