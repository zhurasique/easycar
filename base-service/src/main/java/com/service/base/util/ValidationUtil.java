package com.service.base.util;

import com.service.base.model.Model;
import com.service.base.model.Type;
import com.service.base.repository.*;
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


    // Type
    public static boolean validateTypeName(String name, TypeRepo typeRepo) {
        return !isNull(name) && isCorrectLength(name, 3, 30) && isNull(typeRepo.findByName(name));
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
        return !isNull(id) && isOptionalEmpty(brandRepo.findById(id));
    }


    // TypeModel
    public static boolean validateTypeModelType(String id, TypeRepo typeRepo) {
        return !isNull(id) && isOptionalEmpty(typeRepo.findById(id));
    }

    public static boolean validateTypeModelModel(String id, ModelRepo modelRepo) {
        return !isNull(id) && isOptionalEmpty(modelRepo.findById(id));
    }

    public static boolean validateTypeModel(Type type, Model model, TypeModelRepo typeModelRepo) {
        return typeModelRepo.findByTypeInAndModelIn(type, model).isEmpty();
    }


    // Generation
    public static boolean validateGenerationName(String name) {
        return !isNull(name) && isCorrectLength(name, 1, 30);
    }

    public static boolean validateGenerationModel(String id, ModelRepo modelRepo) {
        return !isNull(id) && isOptionalEmpty(modelRepo.findById(id));
    }

    public static boolean validateGenerationYears(int yearFrom, int yearTo) {
        return yearFrom >= 1885 && yearFrom <= yearTo;
    }


    // Equipment
    public static boolean validateEquipmentName(String name, EquipmentRepo equipmentRepo) {
        return !isNull(name) && isNull(equipmentRepo.findByName(name));
    }

}
