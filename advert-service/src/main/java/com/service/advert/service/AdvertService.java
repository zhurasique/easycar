package com.service.advert.service;

import com.service.advert.entity.Advert;
import com.service.advert.repository.AdvertRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvertService {

    private final AdvertRepo advertRepo;

    public List<Advert> findAll() {
        return advertRepo.findAll();
    }

    @Transactional
    public Advert save(Advert advert) {
        return advertRepo.save(advert);
    }
}
