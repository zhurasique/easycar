package com.service.advert.service;

import com.service.advert.VO.Image;
import com.service.advert.model.Advert;
import com.service.advert.model.AdvertImage;
import com.service.advert.repository.AdvertImageRepo;
import com.service.advert.util.MultipartFileUtil;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class AdvertImageService {

    private final AdvertImageRepo advertImageRepo;
    private final AdvertService advertService;
    private final RestTemplate restTemplate;

    public AdvertImageService(AdvertImageRepo advertImageRepo, AdvertService advertService, RestTemplate restTemplate) {
        this.advertImageRepo = advertImageRepo;
        this.advertService = advertService;
        this.restTemplate = restTemplate;
    }

    public List<AdvertImage> findAll() {
        return advertImageRepo.findAll();
    }

    public List<AdvertImage> findByAdvertId(String id) {
        return advertImageRepo.findByAdvertId(id);
    }

    public ResponseEntity<?> save(Advert advert, List<MultipartFile> images) throws Exception {

        for(MultipartFile imageToSave : images) {
            Image image = new Image();
            image.setId(MultipartFileUtil.postForEntity(imageToSave, restTemplate, "http://gateway/api/image-service/images").getString("id"));
            image.setImage(new Binary(BsonBinarySubType.BINARY, imageToSave.getBytes()));

            AdvertImage advertImage = new AdvertImage();
            advertImage.setAdvert(advertService.findById(advert.getId()));
            advertImage.setImage(image);

            advertImageRepo.save(advertImage);
        }

        return new ResponseEntity<>(findByAdvertId(advert.getId()), HttpStatus.OK);
    }
}
