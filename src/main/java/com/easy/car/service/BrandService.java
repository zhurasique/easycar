package com.easy.car.service;

import com.easy.car.model.Brand;
import com.easy.car.model.Model;
import com.easy.car.repository.BrandRepo;
import com.easy.car.util.ErrorLogUtil;
import com.easy.car.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    public ResponseEntity<?> save(String name, String imageUrl) {

        if(!ValidationUtil.validateBrandName(name, brandRepo))
            return new ResponseEntity<>(ErrorLogUtil.showError(103), HttpStatus.BAD_REQUEST);

        Brand brand = new Brand();

        brand.setName(name);
        brand.setImageUrl(imageUrl);

        return new ResponseEntity<>(brandRepo.save(brand), HttpStatus.OK);
    }
}
