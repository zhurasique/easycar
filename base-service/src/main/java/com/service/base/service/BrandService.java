package com.service.base.service;

import com.service.base.vo.ImageVo;
import com.service.base.entity.Brand;
import com.service.base.exception.NoSuchElementFoundException;
import com.service.base.repository.BrandRepo;
import com.service.base.util.MultipartFileUtil;
import lombok.RequiredArgsConstructor;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.json.JSONException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService {

    private static final String IMAGE_SERVICE_PATH = "http://gateway/api/image-service";

    private final RestTemplate restTemplate;
    private final BrandRepo brandRepo;

    public List<Brand> findAll(){
        return brandRepo.findAll();
    }

    public Brand findById(String id) {
        return brandRepo.findById(id).orElseThrow(() -> new NoSuchElementFoundException(id));
    }

    public Brand save(Brand.Dto brandDto) throws IOException, JSONException {
        ImageVo image = new ImageVo();
        image.setId(MultipartFileUtil.postForEntity(brandDto.getImage(), restTemplate,
                IMAGE_SERVICE_PATH + "/image").getString("id"));
        image.setImage(new Binary(BsonBinarySubType.BINARY, brandDto.getImage().getBytes()));

        Brand brand = new Brand();
        brand.setName(brandDto.getName());
        brand.setImage(image);
        return brandRepo.save(brand);
    }
}
