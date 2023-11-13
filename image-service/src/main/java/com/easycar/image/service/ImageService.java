package com.easycar.image.service;

import com.easycar.common.exception.NoSuchElementFoundException;
import com.easycar.image.entity.Image;
import com.easycar.image.repository.ImageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepo imageRepo;

    public List<Image> findAll() {
        return imageRepo.findAll();
    }

    public Image findById(String id) {
        return imageRepo.findById(id).orElseThrow(() -> new NoSuchElementFoundException(id));
    }

    public void delete(String id) {
        imageRepo.delete(findById(id));
    }

    public Image save(byte[] imageBytes) {
        Image img = new Image();
        img.setBase64Image(imageBytes);
        return imageRepo.save(img);
    }

    public Image save(MultipartFile image) throws IOException {
        Image img = new Image();
        img.setBase64Image(image.getBytes());
        return imageRepo.save(img);
    }
}
