package com.easycar.base.controller;

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
import com.easycar.base.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/brand/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Brand save(@Valid Brand.Dto brand) throws IOException {
        return adminService.save(brand);
    }

    @PutMapping("/car/update/{id}")
    @PreAuthorize("#oauth2.hasScope('server') or hasAuthority('ROLE_ADMIN')")
    public Car update(@PathVariable String id, @Valid @RequestBody Car newData) {
        return adminService.update(id, newData);
    }

    @DeleteMapping("/car/delete{id}")
    @PreAuthorize("#oauth2.hasScope('server') or hasAuthority('ROLE_ADMIN')")
    public void deleteCar(@PathVariable String id) {
        adminService.deleteCar(id);
    }

    @PostMapping("/car/create/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("#oauth2.hasScope('server') or hasAuthority('ROLE_ADMIN')")
    public Car save(@Valid @RequestBody Car car) {
        return adminService.save(car);
    }

    @PostMapping("/car-equipment/create")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public CarEquipment save(@Valid @RequestBody CarEquipment carEquipment) {
        return adminService.save(carEquipment);
    }

    @PostMapping("/city/create")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public City save(@Valid @RequestBody City city) {
        return adminService.save(city);
    }

    @PostMapping("/color/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Color save(@Valid @RequestBody Color color) {
        return adminService.save(color);
    }

    @PostMapping("/equipment/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Equipment save(@Valid @RequestBody Equipment equipment) {
        return adminService.save(equipment);
    }

    @PostMapping("/generation/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Generation save(@Valid @RequestBody Generation generation) {
        return adminService.save(generation);
    }

    @PutMapping("/location/update/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Location update(@PathVariable String id,
                           @Valid @RequestBody Location newData) {
        return adminService.update(id, newData);
    }

    @DeleteMapping("/location/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void deleteLocation(@PathVariable String id) {
        adminService.deleteLocation(id);
    }

    @PostMapping("/location/create")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Location save(@Valid @RequestBody Location location) {
        return adminService.save(location);
    }

    @PostMapping("/model/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Model save(@Valid @RequestBody Model model) {
        return adminService.save(model);
    }

    @PostMapping("/region/create")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Region save(@Valid @RequestBody Region region) {
        return adminService.save(region);
    }

    @PostMapping("/type/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Type save(@Valid Type.Dto type) throws IOException {
        return adminService.save(type);
    }
}
