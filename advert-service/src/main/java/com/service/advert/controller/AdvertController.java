package com.service.advert.controller;

import com.service.advert.entity.Advert;
import com.service.advert.service.AdvertService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @GetMapping("{id}")
    public Advert findById(@PathVariable String id) {
        return advertService.findById(id);
    }

    @PatchMapping("/archive/{id}")
    public Advert archive(@PathVariable String id) {
        return advertService.archive(id);
    }

    @PutMapping("{id}")
    public Advert update(@PathVariable String id,
                         @Valid @RequestBody Advert newData) {
        return advertService.update(id, newData);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        advertService.delete(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Advert save(@Valid @RequestBody Advert advert) {
        return advertService.save(advert);
    }
}
