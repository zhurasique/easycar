package com.service.image.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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


    // Image
    public static boolean validateImageData(MultipartFile multipartFile) throws IOException {
        return multipartFile.getBytes().length > 0;
    }
}
