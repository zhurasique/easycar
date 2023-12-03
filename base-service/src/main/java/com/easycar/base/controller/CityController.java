package com.easycar.base.controller;

import com.easycar.base.entity.City;
import com.easycar.base.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/city")
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
}
