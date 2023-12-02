package com.easycar.base.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AggregateService {

    private final BrandService brandService;
    private final RegionService regionService;

    public Map<String, Object> getBrandsAndRegions() {
        Map<String, Object> response = new HashMap<>();
        response.put("brands", brandService.findAll());
        response.put("regions", regionService.findAll());
        return response;
    }
}
