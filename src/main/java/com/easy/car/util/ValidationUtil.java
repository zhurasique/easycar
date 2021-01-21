package com.easy.car.util;

import com.easy.car.repository.BrandRepo;
import com.easy.car.repository.ModelRepo;
import com.easy.car.repository.TypeRepo;

public abstract class ValidationUtil {

    private static boolean isNull(Object o) {
        return o == null;
    }

    private static boolean isCorrectLength(Object o, int minLength, int maxLength) {
        return o.toString().length() >= minLength || o.toString().length() <= maxLength;
    }


    // Type
    public static boolean validateTypeName(String name, TypeRepo typeRepo) {
        return !isNull(name) && isCorrectLength(name, 3, 30) && isNull(typeRepo.findByName(name));
    }

    public static boolean validateTypeImageUrl(String imageUrl, TypeRepo typeRepo) {
        return !isNull(imageUrl) && isCorrectLength(imageUrl, 3, 150) && isNull(typeRepo.findByImageUrl(imageUrl));
    }


    // Brand
    public static boolean validateBrandName(String name, BrandRepo brandBrand) {
        return !isNull(name) && isCorrectLength(name, 2, 30) && isNull(brandBrand.findByName(name));
    }


    // Model
    public static boolean validateModelName(String name, ModelRepo modelRepo) {
        return !isNull(name) && isCorrectLength(name, 1, 30) && isNull(modelRepo.findByName(name));
    }

    public static boolean validateModelBrand(String id, BrandRepo brandRepo) {
        return !isNull(id) && !isNull(brandRepo.findById(id));
    }
}
