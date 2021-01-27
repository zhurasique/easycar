package com.service.advert.controller;

import com.service.advert.model.Advert;
import com.service.advert.service.AdvertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/advert-service/adverts")
public class AdvertController {

    private final AdvertService advertService;

    public AdvertController(AdvertService advertService) {
        this.advertService = advertService;
    }

    @GetMapping
    public List<Advert> findAll() {
        return advertService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Advert advert) {
        return advertService.save(advert);
    }
}
