package com.service.base.service;

import com.service.base.entity.Car;
import com.service.base.entity.Generation;
import com.service.base.exception.BusinessLogicException;
import com.service.base.exception.NoSuchElementFoundException;
import com.service.base.repository.CarRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepo carRepo;
    private final GenerationService generationService;
    private final ColorService colorService;
    private final TypeService typeService;

    public Car findById(String id) {
        return carRepo.findById(id).orElseThrow(() -> new NoSuchElementFoundException(id));
    }

    public Car update(String id, Car newData) {
        Car oldData = findById(id);
        oldData.setGeneration(generationService.findById(newData.getGeneration().getId()));
        oldData.setColor(colorService.findById(newData.getColor().getId()));
        oldData.setType(typeService.findById(newData.getType().getId()));
        Generation generation = newData.getGeneration();
        int yearOfProduction = newData.getYerOfProduction();
        if (yearOfProduction < generation.getYearFrom() || yearOfProduction > generation.getYearTo()) {
            throw new BusinessLogicException("Year of production must be in scope of generation years");
        }
        oldData.setFuel(newData.getFuel());
        oldData.setDrive(newData.getDrive());
        oldData.setTransmission(newData.getTransmission());
        oldData.setEngineCapacity(newData.getEngineCapacity());
        oldData.setPower(newData.getPower());
        oldData.setYerOfProduction(newData.getYerOfProduction());
        oldData.setOdometer(newData.getOdometer());
        return carRepo.save(oldData);
    }

    public void delete(String id) {
        carRepo.delete(findById(id));
    }

    public Car save(Car car) {
        car.setGeneration(generationService.findById(car.getGeneration().getId()));
        car.setColor(colorService.findById(car.getColor().getId()));
        car.setType(typeService.findById(car.getType().getId()));
        Generation generation = car.getGeneration();
        int yerOfProduction = car.getYerOfProduction();
        if (yerOfProduction < generation.getYearFrom() || yerOfProduction > generation.getYearTo()) {
            throw new BusinessLogicException("Year of production must be in scope of generation years");
        }
        return carRepo.save(car);
    }
}
