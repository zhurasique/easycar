package com.easycar.image.controller;

import com.easycar.image.entity.Image;
import com.easycar.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@PreAuthorize("#oauth2.hasScope('server') or hasAuthority('ROLE_ADMIN')")
public class ImageController {

    private final ImageService imageService;

    @GetMapping("{id}")
    public Image findById(@PathVariable("id") String id) {
        return imageService.findById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        imageService.delete(id);
    }

    @PostMapping("/base64")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Image save(@RequestBody byte[] imageBytes) {
        return imageService.save(imageBytes);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Image save(@Valid MultipartFile image) throws IOException {
        return imageService.save(image);
    }
}
