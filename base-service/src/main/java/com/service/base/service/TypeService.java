package com.service.base.service;

import com.service.base.client.ImageServiceClient;
import com.service.base.vo.Image;
import com.service.base.entity.Type;
import com.service.base.repository.TypeRepo;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeService {

    private final ImageServiceClient imageServiceClient;
    private final TypeRepo typeRepo;

    public List<Type> findAll() {
        return typeRepo.findAll();
    }

    public Type save(Type.Dto typeDto) throws IOException {
//        Image image = imageServiceClient.save(typeDto.getImage());

        Type type = new Type();
        type.setName(typeDto.getName());
//        type.setImage(image);
        return typeRepo.save(type);
    }
}
