package com.service.advert.util;

import com.service.advert.VO.Brand;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

public abstract class ValidationUtil {

    public static boolean isNull(Object o) {
        return o == null;
    }

    public static boolean isOptionalEmpty(Optional<?> optional) {
        return optional.isPresent();
    }

    public static boolean isCorrectLength(Object o, int minLength, int maxLength) {
        return o.toString().length() >= minLength && o.toString().length() <= maxLength;
    }


    // Advert
    public static boolean validateAdvertBrand(String id, RestTemplate restTemplate) {
        return !isNull(restTemplate.getForObject("http://localhost:8081/api/brands/" + id, Brand.class));
    }
}
