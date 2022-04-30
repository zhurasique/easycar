package com.service.image.service;

import com.service.image.entity.Image;
import com.service.image.repository.ImageRepo;
import lombok.RequiredArgsConstructor;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepo imageRepo;

    public Image findById(String id) {
        return imageRepo.findById(id).orElseGet(null);
    }

    public Image save(MultipartFile multipartFile) throws IOException {
        Image image = new Image();
        image.setImage(new Binary(BsonBinarySubType.BINARY, multipartFile.getBytes()));
        return imageRepo.save(image);
    }
}
