package com.service.advert.controller;

import com.service.advert.entity.Advert;
import com.service.advert.service.AdvertService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/advert-service/advert")
public class AdvertController {

    public final AdvertService advertService;

    public AdvertController(AdvertService advertService) {
        this.advertService = advertService;
    }

    @GetMapping
    public List<Advert> findAll() {
        return advertService.findAll();
    }

    @PostMapping
    public Advert save(@Valid @RequestBody Advert advert) {
        return advertService.save(advert);
    }
}
