package com.service.advert.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/advert-service/advert")
public class AdvertController {
    @GetMapping
    public ResponseEntity<?> init() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
