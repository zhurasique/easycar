package com.service.base.service;

import com.service.base.model.Brand;
import com.service.base.repository.BrandRepo;
import com.service.base.util.ErrorLogUtil;
import com.service.base.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class BrandService {

    private final BrandRepo brandRepo;

    public BrandService(BrandRepo brandRepo) {
        this.brandRepo = brandRepo;
    }

    public List<Brand> findAll(){
        return brandRepo.findAll();
    }

    public Brand findById(String id) throws Exception {
        return brandRepo.findById(id).orElseThrow(Exception::new);
    }

    public ResponseEntity<?> save(Brand brand, MultipartFile multipartFile) {

        if(!ValidationUtil.validateBrandName(brand.getName(), brandRepo))
            return new ResponseEntity<>(ErrorLogUtil.showError(103), HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(brandRepo.save(brand), HttpStatus.OK);
    }
}
