package com.service.base.service;

import com.service.base.vo.ImageVo;
import com.service.base.entity.Type;
import com.service.base.repository.TypeRepo;
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
public class TypeService {

    private static final String IMAGE_SERVICE_PATH = "http://gateway/api/image-service";

    private final RestTemplate restTemplate;
    private final TypeRepo typeRepo;

    public List<Type> findAll() {
        return typeRepo.findAll();
    }

    public Type save(Type.Dto typeDto)
            throws IOException, JSONException {
        ImageVo image = new ImageVo();
        image.setId(MultipartFileUtil.postForEntity(typeDto.getImage(), restTemplate,
                IMAGE_SERVICE_PATH + "/image").getString("id"));
        image.setImage(new Binary(BsonBinarySubType.BINARY, typeDto.getImage().getBytes()));

        Type type = new Type();
        type.setName(typeDto.getName());
        type.setImage(image);
        return typeRepo.save(type);
    }
}
