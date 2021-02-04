package com.service.advert.controller;

import com.service.advert.model.Advert;
import com.service.advert.model.AdvertImage;
import com.service.advert.service.AdvertImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/advert-service/advert_image")
public class AdvertImageController {

    private final AdvertImageService advertImageService;

    public AdvertImageController(AdvertImageService advertImageService) {
        this.advertImageService = advertImageService;
    }

    @GetMapping
    public List<AdvertImage> findAll() {
        return advertImageService.findAll();
    }

    @GetMapping("/advert/{id}")
    public List<AdvertImage> findByAdvertId(@PathVariable("id") String id) {
        return advertImageService.findByAdvertId(id);
    }

    @PostMapping
    public ResponseEntity<?> save(Advert advert, List<MultipartFile> images) throws Exception {
        return advertImageService.save(advert, images);
    }
}
