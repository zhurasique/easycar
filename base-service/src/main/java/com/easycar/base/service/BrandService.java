package com.easycar.base.service;

import com.easycar.common.exception.NoSuchElementFoundException;
import com.easycar.base.client.ImageServiceClient;
import com.easycar.base.entity.Brand;
import com.easycar.base.repository.BrandRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Brand save(Brand.Dto brandDto) throws IOException {
        return brandRepo.save(Brand.builder()
                .name(brandDto.getName())
                .image(imageServiceClient.save(brandDto.getImage().getBytes()))
                .build());
    }
}
