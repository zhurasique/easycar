package com.service.base.service;

import com.service.base.model.Fuel;
import com.service.base.repository.FuelRepo;
import com.service.base.util.ErrorLogUtil;
import com.service.base.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelService {

    private final FuelRepo fuelRepo;

    public FuelService(FuelRepo fuelRepo) {
        this.fuelRepo = fuelRepo;
    }

    public List<Fuel> findAll() {
        return fuelRepo.findAll();
    }

    public ResponseEntity<?> save(Fuel fuel) {

        if(!ValidationUtil.validateFuelName(fuel.getName(), fuelRepo))
            return new ResponseEntity<>(ErrorLogUtil.showError(118), HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(fuelRepo.save(fuel), HttpStatus.OK);
    }
}
