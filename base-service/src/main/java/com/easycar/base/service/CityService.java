package com.easycar.base.service;

import com.easycar.common.exception.NoSuchElementFoundException;
import com.easycar.base.entity.City;
import com.easycar.base.repository.CityRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepo cityRepo;
    private final RegionService regionService;

    public List<City> findByRegionId(String id) {
        return cityRepo.findByRegionId(id);
    }

    public City findById(String id) {
        return cityRepo.findById(id).orElseThrow(() -> new NoSuchElementFoundException(id));
    }

    public City save(City city) {
        city.setRegion(regionService.findById(city.getRegion().getId()));
        return cityRepo.save(city);
    }
}
