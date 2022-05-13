package com.service.base.service;

import com.service.base.client.ImageServiceClient;
import com.service.base.vo.Image;
import com.service.base.entity.Brand;
import com.service.base.exception.NoSuchElementFoundException;
import com.service.base.repository.BrandRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final ImageServiceClient imageServiceClient;
    private final BrandRepo brandRepo;

    public List<Brand> findAll(){
        return brandRepo.findAll();
    }

    public Brand findById(String id) {
        return brandRepo.findById(id).orElseThrow(() -> new NoSuchElementFoundException(id));
    }

    public Brand save(Brand.Dto brandDto) throws IOException {
        Image image = imageServiceClient.save(brandDto.getImage().getBytes());

        Brand brand = new Brand();
        brand.setName(brandDto.getName());
        brand.setImage(image);
        return brandRepo.save(brand);
    }
}
