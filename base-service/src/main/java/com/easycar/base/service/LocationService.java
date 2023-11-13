package com.easycar.base.service;

import com.easycar.common.exception.NoSuchElementFoundException;
import com.easycar.base.entity.Location;
import com.easycar.base.repository.LocationRepo;
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

    public Location update(String id, Location newData) {
        Location oldData = findById(id);
        oldData.setStreetName(newData.getStreetName());
        oldData.setCity(cityService.findById(newData.getCity().getId()));
        return oldData;
    }

    public void delete(String id) {
        locationRepo.delete(findById(id));
    }

    public Location save(Location location) {
        location.setCity(cityService.findById(location.getCity().getId()));
        return locationRepo.save(location);
    }
}
