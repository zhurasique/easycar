package com.service.base.service;

import com.service.base.VO.Image;
import com.service.base.model.Brand;
import com.service.base.repository.BrandRepo;
import com.service.base.util.ErrorLogUtil;
import com.service.base.util.MultipartFileUtil;
import com.service.base.util.ValidationUtil;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class BrandService {

    private final RestTemplate restTemplate;

    private final BrandRepo brandRepo;

    public BrandService(RestTemplate restTemplate, BrandRepo brandRepo) {
        this.restTemplate = restTemplate;
        this.brandRepo = brandRepo;
    }

    public List<Brand> findAll(){
        return brandRepo.findAll();
    }

    public Brand findById(String id) throws Exception {
        return brandRepo.findById(id).orElseThrow(Exception::new);
    }

    public ResponseEntity<?> save(String name, MultipartFile multipartFile) throws IOException, JSONException {

        if(!ValidationUtil.validateBrandName(name, brandRepo))
            return new ResponseEntity<>(ErrorLogUtil.showError(103), HttpStatus.BAD_REQUEST);

        Image image = new Image();
        image.setId(MultipartFileUtil.postForEntity(multipartFile, restTemplate, "http://IMAGE-SERVICE/api/images").getString("id"));
        image.setImage(new Binary(BsonBinarySubType.BINARY, multipartFile.getBytes()));

        Brand brand = new Brand();
        brand.setName(name);
        brand.setImage(image);

        return new ResponseEntity<>(brandRepo.save(brand), HttpStatus.OK);
    }


}
