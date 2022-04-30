package com.service.base.service;

import com.service.base.entity.Fuel;
import com.service.base.repository.FuelRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuelService {

    private final FuelRepo fuelRepo;

    public List<Fuel> findAll() {
        return fuelRepo.findAll();
    }

    public Fuel save(Fuel fuel) {
        return fuelRepo.save(fuel);
    }
}
