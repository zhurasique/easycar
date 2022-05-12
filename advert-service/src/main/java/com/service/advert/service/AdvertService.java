package com.service.advert.service;

import com.service.advert.entity.Advert;
import com.service.advert.repository.AdvertRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertService {

    private final AdvertRepo advertRepo;

    public AdvertService(AdvertRepo advertRepo) {
        this.advertRepo = advertRepo;
    }

    public List<Advert> findAll() {
        return advertRepo.findAll();
    }

    public Advert save(Advert advert) {
        return advertRepo.save(advert);
    }
}
