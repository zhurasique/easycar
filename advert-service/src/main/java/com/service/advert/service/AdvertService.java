package com.service.advert.service;

import com.service.advert.VO.Brand;
import com.service.advert.model.Advert;
import com.service.advert.repository.AdvertRepo;
import com.service.advert.util.ErrorLogUtil;
import com.service.advert.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AdvertService {

    private final RestTemplate restTemplate;

    private final AdvertRepo advertRepo;

    public AdvertService(RestTemplate restTemplate, AdvertRepo advertRepo) {
        this.restTemplate = restTemplate;
        this.advertRepo = advertRepo;
    }

    public List<Advert> findAll() {
        return advertRepo.findAll();
    }

    public ResponseEntity<?> save(Advert advert) {

        if(!ValidationUtil.validateAdvertBrand(advert.getBrand().getId(), restTemplate))
            return new ResponseEntity<>(ErrorLogUtil.showError(100), HttpStatus.BAD_REQUEST);

        advert.setBrand(restTemplate.getForObject("http://localhost:8081/api/brands/" + advert.getBrand().getId(), Brand.class));

        return new ResponseEntity<>(advertRepo.save(advert), HttpStatus.OK);
    }
}
