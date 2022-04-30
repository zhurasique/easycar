package com.service.base.service;

import com.service.base.VO.ImageVO;
import com.service.base.entity.Brand;
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

    public Brand findById(String id) throws Exception {
        return brandRepo.findById(id).orElseThrow(Exception::new);
    }

    public Brand save(Brand.Dto brandDto)
            throws IOException, JSONException {
        ImageVO imageVO = new ImageVO();
        imageVO.setId(MultipartFileUtil.postForEntity(brandDto.getImage(), restTemplate,
                IMAGE_SERVICE_PATH + "/image").getString("id"));
        imageVO.setImage(new Binary(BsonBinarySubType.BINARY, brandDto.getImage().getBytes()));

        Brand brand = new Brand();
        brand.setName(brandDto.getName());
        brand.setImageVO(imageVO);
        return brandRepo.save(brand);
    }
}
