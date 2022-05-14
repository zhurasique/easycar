package com.service.base.service;

import com.service.base.entity.Car;
import com.service.base.exception.NoSuchElementFoundException;
import com.service.base.repository.CarRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepo carRepo;

    public Car findById(String id) {
        return carRepo.findById(id).orElseThrow(() -> new NoSuchElementFoundException(id));
    }

    public Car save(Car car) {
        return carRepo.save(car);
    }
}
