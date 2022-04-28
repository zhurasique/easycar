package com.service.image.controller;

import com.service.image.entity.Image;
import com.service.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/image-service/image")
public class ImageController {

    private final ImageService imageService;

    @GetMapping("{id}")
    public Image findById(@PathVariable("id") String id) throws Exception {
        return imageService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(MultipartFile image) throws IOException {
        return imageService.save(image);
    }
}
