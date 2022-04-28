package com.service.base.service;

import com.service.base.entity.Fuel;
import com.service.base.repository.FuelRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuelService {

    private final FuelRepo fuelRepo;

    public List<Fuel> findAll() {
        return fuelRepo.findAll();
    }

    public ResponseEntity<?> save(Fuel fuel) {
        return new ResponseEntity<>(fuelRepo.save(fuel), HttpStatus.OK);
    }
}
