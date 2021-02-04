package com.service.advert.service;

import com.service.advert.model.Advert;
import com.service.advert.repository.AdvertRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    public Advert findById(String id) throws Exception {
        return advertRepo.findById(id).orElseThrow(Exception::new);
    }

    public ResponseEntity<?> save(Advert advert, List<MultipartFile> images){
        return new ResponseEntity<>(advertRepo.save(advert), HttpStatus.OK);
    }
}
