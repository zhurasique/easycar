package com.easycar.advert.service;

import com.easycar.common.exception.NoSuchElementFoundException;
import com.easycar.advert.client.ImageServiceClient;
import com.easycar.advert.entity.AdvertImage;
import com.easycar.advert.repository.AdvertImageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvertImageService {

    private final AdvertImageRepo advertImageRepo;
    private final ImageServiceClient imageServiceClient;
    private final AdvertService advertService;

    public AdvertImage findById(String id) {
        return advertImageRepo.findById(id).orElseThrow(() -> new NoSuchElementFoundException(id));
    }

    public List<AdvertImage> findByAdvertId(String id) {
        return advertImageRepo.findByAdvertId(id);
    }

    public AdvertImage setMain(String imageId, String advertId) {
        AdvertImage advertImage = findByAdvertId(advertId).stream()
                .filter(x -> x.getId().equals(imageId))
                .findAny()
                .orElseThrow(() -> new NoSuchElementFoundException(imageId));
        advertImage.setMain(true);
        return advertImageRepo.save(advertImage);
    }

    public void delete(String id) {
        advertImageRepo.delete(findById(id));
    }

    @Transactional
    public void deleteByAdvertId(String id) {
        for (AdvertImage advertImage : findByAdvertId(id)) {
            imageServiceClient.delete(advertImage.getImage().getId());
            advertImageRepo.delete(advertImage);
        }
    }

    @Transactional
    public List<AdvertImage> saveAll(String advertId, List<MultipartFile> images) throws IOException {
        List<AdvertImage> savedAdvertImages = new ArrayList<>();
        for (MultipartFile multipartFile : images) {
            AdvertImage advertImage = new AdvertImage();
            advertImage.setAdvert(advertService.findById(advertId));
            advertImage.setImage(imageServiceClient.save(multipartFile.getBytes()));
            savedAdvertImages.add(advertImageRepo.save(advertImage));
        }
        return savedAdvertImages;
    }
}
