package com.service.advert.service;

import com.service.advert.client.BaseServiceClient;
import com.service.advert.client.LocationServiceClient;
import com.service.advert.client.UserServiceClient;
import com.service.advert.entity.Advert;
import com.service.advert.exception.NoSuchElementFoundException;
import com.service.advert.repository.AdvertRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvertService {

    private final AdvertRepo advertRepo;
    private final BaseServiceClient baseServiceClient;
    private final LocationServiceClient locationServiceClient;
    private final UserServiceClient userServiceClient;

    public List<Advert> findAll() {
        return advertRepo.findAll();
    }

    public Advert findById(String id) {
        return advertRepo.findById(id).orElseThrow(() -> new NoSuchElementFoundException(id));
    }

    public Advert archive(String id) {
        Advert advert = findById(id);
        advert.setPostDateTime(LocalDateTime.now());
        advert.setActive(!advert.isActive());
        return advertRepo.save(advert);
    }

    @Transactional
    public Advert update(String id, Advert newData) {
        Advert oldData = findById(id);
        oldData.setPostDateTime(LocalDateTime.now());
        oldData.setTitle(newData.getTitle());
        oldData.setDescription(newData.getDescription());
        oldData.setPrice(newData.getPrice());
        oldData.setActive(newData.isActive());
        oldData.setCurrency(newData.getCurrency());
        oldData.setCar(baseServiceClient.updateCar(oldData.getCar().getId(), newData.getCar()));
        oldData.setLocation(locationServiceClient.updateLocation(oldData.getLocation().getId(), newData.getLocation()));
        return advertRepo.save(oldData);
    }

    @Transactional
    public void delete(String id) {
        Advert advert = findById(id);
        baseServiceClient.deleteCar(advert.getCar().getId());
        locationServiceClient.deleteLocation(advert.getLocation().getId());
        advertRepo.delete(advert);
    }

    @Transactional
    public Advert save(Advert advert) {
        advert.setPostDateTime(LocalDateTime.now());
        advert.setActive(true);
        advert.setCar(baseServiceClient.saveCar(advert.getCar()));
        advert.setLocation(locationServiceClient.saveLocation(advert.getLocation()));
        advert.setUser(userServiceClient.findById(advert.getUser().getId()));
        return advertRepo.save(advert);
    }
}
