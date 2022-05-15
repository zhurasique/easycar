package com.service.location.controller;

import com.service.location.entity.Location;
import com.service.location.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequiredArgsConstructor
@RequestMapping("api/location-service/location")
public class LocationController {

    private final LocationService locationService;

    @GetMapping("/city/{id}")
    public List<Location> findByCityId(@PathVariable String id) {
        return locationService.findByCityId(id);
    }

    @GetMapping("{id}")
    public Location findById(@PathVariable String id) {
        return locationService.findById(id);
    }

    @PutMapping("{id}")
    public Location update(@PathVariable String id,
                           @Valid @RequestBody Location newData) {
        return locationService.update(id, newData);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        locationService.delete(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Location save(@Valid @RequestBody Location location) {
        return locationService.save(location);
    }
}
