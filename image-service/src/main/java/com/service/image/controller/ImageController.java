package com.service.image.controller;

import com.service.image.entity.Image;
import com.service.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/image-service/image")
public class ImageController {

    private final ImageService imageService;

    @GetMapping("{id}")
    public Image findById(@PathVariable("id") String id) {
        return imageService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid MultipartFile image) throws IOException {
        return imageService.save(image);
    }
}
