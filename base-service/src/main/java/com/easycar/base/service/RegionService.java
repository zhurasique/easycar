package com.easycar.base.service;

import com.easycar.common.exception.NoSuchElementFoundException;
import com.easycar.base.entity.Region;
import com.easycar.base.repository.RegionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final RegionRepo regionRepo;

    public List<Region> findAll() {
        return regionRepo.findAll();
    }

    public Region findById(String id) {
        return regionRepo.findById(id).orElseThrow(() -> new NoSuchElementFoundException(id));
    }

    public Region save(Region region) {
        return regionRepo.save(region);
    }
}
