package com.service.base.controller;

import com.service.base.entity.Type;
import com.service.base.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/base-service/type")
public class TypeController {

    private final TypeService typeService;

    @GetMapping
    public List<Type> findAll() {
        return typeService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestPart(name = "name") String name, @RequestPart(name = "image") MultipartFile image) throws IOException, JSONException {
        return typeService.save(name, image);
    }
}
