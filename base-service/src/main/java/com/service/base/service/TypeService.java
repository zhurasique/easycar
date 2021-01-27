package com.service.base.service;

import com.service.base.VO.Image;
import com.service.base.model.Type;
import com.service.base.repository.TypeRepo;
import com.service.base.util.ErrorLogUtil;
import com.service.base.util.MultipartFileUtil;
import com.service.base.util.ValidationUtil;
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
public class TypeService {

    private final RestTemplate restTemplate;

    private final TypeRepo typeRepo;

    public TypeService(RestTemplate restTemplate, TypeRepo typeRepo) {
        this.restTemplate = restTemplate;
        this.typeRepo = typeRepo;
    }

    public List<Type> findAll() {
        return typeRepo.findAll();
    }

    public ResponseEntity<?> save(String name, MultipartFile multipartFile) throws IOException, JSONException {

        if(!ValidationUtil.validateTypeName(name, typeRepo))
            return new ResponseEntity<>(ErrorLogUtil.showError(101), HttpStatus.BAD_REQUEST);

        Image image = new Image();
        image.setId(MultipartFileUtil.postForEntity(multipartFile, restTemplate, "http://API-GATEWAY/api/image-service/images").getString("id"));
        image.setImage(new Binary(BsonBinarySubType.BINARY, multipartFile.getBytes()));

        Type type = new Type();
        type.setName(name);
        type.setImage(image);

        return new ResponseEntity<>(typeRepo.save(type), HttpStatus.OK);
    }
}
