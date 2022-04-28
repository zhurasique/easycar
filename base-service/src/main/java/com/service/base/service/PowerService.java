package com.service.base.service;

import com.service.base.entity.Power;
import com.service.base.repository.PowerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PowerService {

    private final PowerRepo powerRepo;

    public List<Power> findAll() {
        return powerRepo.findAll();
    }

    public ResponseEntity<?> save(Power power) {
        return new ResponseEntity<>(powerRepo.save(power), HttpStatus.OK);
    }
}
