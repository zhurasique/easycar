package com.easycar.advert.client;

import com.easycar.advert.vo.Car;
import com.easycar.advert.vo.Location;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "base-service")
@RequestMapping("/api/base-service")
public interface BaseServiceClient {
    @GetMapping("/car/{id}")
    Car findCarById(@PathVariable String id);

    @DeleteMapping("/car/{id}")
    void deleteCar(@PathVariable String id);

    @PutMapping("/car/{id}")
    Car updateCar(@PathVariable String id, @RequestBody Car newData);

    @PostMapping("/car")
    Car saveCar(@RequestBody Car car);

    @PostMapping("/location")
    Location saveLocation(@RequestBody Location location);

    @DeleteMapping("/location/{id}")
    void deleteLocation(@PathVariable String id);

    @PutMapping("/location/{id}")
    Location updateLocation(@PathVariable String id, @RequestBody Location newData);
}
