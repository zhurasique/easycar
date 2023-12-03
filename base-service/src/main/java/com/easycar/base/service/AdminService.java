package com.easycar.base.service;

import com.easycar.base.entity.Brand;
import com.easycar.base.entity.Car;
import com.easycar.base.entity.CarEquipment;
import com.easycar.base.entity.City;
import com.easycar.base.entity.Color;
import com.easycar.base.entity.Equipment;
import com.easycar.base.entity.Generation;
import com.easycar.base.entity.Location;
import com.easycar.base.entity.Model;
import com.easycar.base.entity.Region;
import com.easycar.base.entity.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final BrandService brandService;
    private final CarEquipmentService carEquipmentService;
    private final CarService carService;
    private final CityService cityService;
    private final ColorService colorService;
    private final EquipmentService equipmentService;
    private final GenerationService generationService;
    private final LocationService locationService;
    private final ModelService modelService;
    private final RegionService regionService;
    private final TypeService typeService;

    public Brand save(Brand.Dto brand) throws IOException {
        return brandService.save(brand);
    }

    public Car update(String id, Car newData) {
        return carService.update(id, newData);
    }

    public void deleteCar(String id) {
        carService.delete(id);
    }

    public Car save(Car car) {
        return carService.save(car);
    }

    public CarEquipment save(CarEquipment carEquipment) {
        return carEquipmentService.save(carEquipment);
    }

    public City save(City city) {
        return cityService.save(city);
    }

    public Color save(Color color) {
        return colorService.save(color);
    }

    public Equipment save(Equipment equipment) {
        return equipmentService.save(equipment);
    }

    public Generation save(Generation generation) {
        return generationService.save(generation);
    }

    public Location update(String id, Location newData) {
        return locationService.update(id, newData);
    }

    public void deleteLocation(String id) {
        locationService.delete(id);
    }

    public Location save(Location location) {
        return locationService.save(location);
    }

    public Model save(Model model) {
        return modelService.save(model);
    }

    public Region save(Region region) {
        return regionService.save(region);
    }

    public Type save(Type.Dto type) throws IOException {
        return typeService.save(type);
    }
}
