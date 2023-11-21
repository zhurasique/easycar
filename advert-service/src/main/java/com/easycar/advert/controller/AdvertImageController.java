package com.easycar.advert.controller;

import com.easycar.advert.entity.AdvertImage;
import com.easycar.advert.service.AdvertImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/advert-image")
public class AdvertImageController {

    private final AdvertImageService advertService;

    @GetMapping("{id}")
    public AdvertImage findById(@PathVariable String id) {
        return advertService.findById(id);
    }

    @GetMapping("/advert/{id}")
    public List<AdvertImage> findByAdvertId(@PathVariable String id) {
        return advertService.findByAdvertId(id);
    }

    @PatchMapping("{imageId}/advert/{advertId}")
    public AdvertImage setMain(@PathVariable String imageId, @PathVariable String advertId) {
        return advertService.setMain(imageId, advertId);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        advertService.delete(id);
    }

    @DeleteMapping("/advert/{id}")
    public void deleteByAdvertId(@PathVariable String id) {
        advertService.deleteByAdvertId(id);
    }

    @PostMapping("/{advertId}")
    public List<AdvertImage> save(@PathVariable String advertId, @RequestBody List<MultipartFile> images) throws IOException {
        return advertService.saveAll(advertId, images);
    }
}
