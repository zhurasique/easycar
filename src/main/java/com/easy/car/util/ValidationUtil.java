package com.easy.car.util;

import com.easy.car.repository.TypeRepo;

public abstract class ValidationUtil {

    private static boolean isNull(Object o) {
        return o == null;
    }

    private static boolean isCorrectLength(Object o, int minLength, int maxLength) {
        return o.toString().length() >= minLength || o.toString().length() <= maxLength;
    }

    public static boolean validateTypeName(String name, TypeRepo typeRepo) {
        return !isNull(name) && isCorrectLength(name, 3, 30) && typeRepo.findByName(name) == null;
    }

    public static boolean validateTypeImageUrl(String imageUrl, TypeRepo typeRepo) {
        return !isNull(imageUrl) && isCorrectLength(imageUrl, 3, 150) && typeRepo.findByImageUrl(imageUrl) == null;
    }
}
