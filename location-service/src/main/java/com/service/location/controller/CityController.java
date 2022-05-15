package com.service.location.controller;

import com.service.location.entity.City;
import com.service.location.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/location-service/city")
public class CityController {

    private final CityService cityService;

    @GetMapping("/region/{id}")
    public List<City> findByRegionId(@PathVariable String id) {
        return cityService.findByRegionId(id);
    }

    @GetMapping("{id}")
    public City findById(@PathVariable String id) {
        return cityService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public City save(@Valid @RequestBody City city) {
        return cityService.save(city);
    }
}
