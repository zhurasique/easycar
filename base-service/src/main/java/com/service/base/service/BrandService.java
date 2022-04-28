package com.service.base.service;

import com.service.base.VO.ImageVO;
import com.service.base.entity.Brand;
import com.service.base.repository.BrandRepo;
import com.service.base.util.ErrorLogUtil;
import com.service.base.util.MultipartFileUtil;
import com.service.base.util.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

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

    public ResponseEntity<?> save(String name, MultipartFile multipartFile)
            throws IOException, JSONException {
        if(!ValidationUtil.validateBrandName(name, brandRepo))
            return new ResponseEntity<>(ErrorLogUtil.showError(103), HttpStatus.BAD_REQUEST);

        ImageVO imageVO = new ImageVO();
        imageVO.setId(MultipartFileUtil.postForEntity(multipartFile, restTemplate,
                IMAGE_SERVICE_PATH + "/image").getString("id"));
        imageVO.setImage(new Binary(BsonBinarySubType.BINARY, multipartFile.getBytes()));

        Brand brand = new Brand();
        brand.setName(name);
        brand.setImageVO(imageVO);

        return new ResponseEntity<>(brandRepo.save(brand), HttpStatus.OK);
    }


}
