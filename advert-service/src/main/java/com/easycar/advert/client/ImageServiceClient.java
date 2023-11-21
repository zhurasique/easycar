package com.easycar.advert.client;

import com.easycar.advert.vo.Image;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "image-service")
@RequestMapping("/api/v1/image")
public interface ImageServiceClient {
    @PostMapping("/base64")
    Image save(byte[] imageBytes);

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id);
}
