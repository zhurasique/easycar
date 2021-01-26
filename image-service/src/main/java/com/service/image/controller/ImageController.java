package com.service.image.controller;

import com.service.image.model.Image;
import com.service.image.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/images")
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("{id}")
    public Image findById(@PathVariable("id") String id) throws Exception {
        return imageService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(MultipartFile multipartFile) throws IOException {
        return imageService.save(multipartFile);
    }
}
