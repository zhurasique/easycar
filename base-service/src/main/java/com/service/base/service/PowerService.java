package com.service.base.service;

import com.service.base.model.Power;
import com.service.base.repository.PowerRepo;
import com.service.base.util.ErrorLogUtil;
import com.service.base.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PowerService {

    private final PowerRepo powerRepo;

    public PowerService(PowerRepo powerRepo) {
        this.powerRepo = powerRepo;
    }

    public List<Power> findAll() {
        return powerRepo.findAll();
    }

    public ResponseEntity<?> save(Power power) {

        if(!ValidationUtil.validatePower(power.getPower(), powerRepo))
            return new ResponseEntity<>(ErrorLogUtil.showError(115), HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(powerRepo.save(power), HttpStatus.OK);
    }
}
