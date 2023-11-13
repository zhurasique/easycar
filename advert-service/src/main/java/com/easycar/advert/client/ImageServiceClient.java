package com.easycar.advert.client;

import com.easycar.advert.vo.Image;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "image-service")
@RequestMapping("/api/image-service")
public interface ImageServiceClient {
    @PostMapping("/image/base64")
    Image save(byte[] imageBytes);

    @DeleteMapping("/image/{id}")
    void delete(@PathVariable String id);
}
