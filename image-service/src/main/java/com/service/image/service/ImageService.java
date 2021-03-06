package com.service.image.service;

import com.service.image.model.Image;
import com.service.image.repository.ImageRepo;
import com.service.image.util.ErrorLogUtil;
import com.service.image.util.ValidationUtil;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {

    private final ImageRepo imageRepo;

    public ImageService(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
    }

    public Image findById(String id) throws Exception {
        return imageRepo.findById(id).orElseThrow(Exception::new);
    }

    public ResponseEntity<?> save(MultipartFile multipartFile) throws IOException {

        if(!ValidationUtil.validateImageData(multipartFile))
            return new ResponseEntity<>(ErrorLogUtil.showError(101), HttpStatus.BAD_REQUEST);

        Image image = new Image();
        image.setImage(new Binary(BsonBinarySubType.BINARY, multipartFile.getBytes()));

        return new ResponseEntity<>(imageRepo.save(image), HttpStatus.OK);
    }
}
