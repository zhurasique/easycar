package com.easycar.base.service;

import com.easycar.common.exception.BusinessLogicException;
import com.easycar.common.exception.NoSuchElementFoundException;
import com.easycar.base.entity.Car;
import com.easycar.base.entity.Generation;
import com.easycar.base.repository.CarRepo;
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
        validateProductionYear(newData);
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
        validateProductionYear(car);
        return carRepo.save(car);
    }

    private void validateProductionYear(Car car) {
        Generation generation = car.getGeneration();
        int yerOfProduction = car.getYerOfProduction();
        if (yerOfProduction < generation.getYearFrom() || yerOfProduction > generation.getYearTo()) {
            throw new BusinessLogicException("Year of production must be in scope of generation years");
        }
    }
}
