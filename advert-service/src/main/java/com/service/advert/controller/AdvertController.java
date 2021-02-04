package com.service.advert.controller;

import com.service.advert.model.Advert;
import com.service.advert.service.AdvertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/advert-service/advert")
public class AdvertController {

    private final AdvertService advertService;

    public AdvertController(AdvertService advertService) {
        this.advertService = advertService;
    }

    @GetMapping
    public List<Advert> findAll() {
        return advertService.findAll();
    }

    @GetMapping("{id}")
    public Advert findById(@PathVariable("id") String id) throws Exception {
        return advertService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Advert advert, @RequestPart(name = "images") List<MultipartFile> images) {
        return advertService.save(advert, images);
    }
}
