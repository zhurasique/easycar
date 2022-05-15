package com.service.location.service;

import com.service.location.entity.Location;
import com.service.location.exception.NoSuchElementFoundException;
import com.service.location.repository.LocationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepo locationRepo;
    private final CityService cityService;

    public List<Location> findByCityId(String id) {
        return locationRepo.findByCityId(id);
    }

    public Location findById(String id) {
        return locationRepo.findById(id).orElseThrow(() -> new NoSuchElementFoundException(id));
    }

    public Location save(Location location) {
        location.setCity(cityService.findById(location.getCity().getId()));
        return locationRepo.save(location);
    }
}
