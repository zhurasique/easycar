package com.service.base.service;

import com.service.base.entity.Power;
import com.service.base.repository.PowerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PowerService {

    private final PowerRepo powerRepo;

    public List<Power> findAll() {
        return powerRepo.findAll();
    }

    public Power save(Power power) {
        return powerRepo.save(power);
    }
}
