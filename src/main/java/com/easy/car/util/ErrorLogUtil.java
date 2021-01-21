package com.easy.car.util;

import java.util.LinkedHashMap;
import java.util.Map;

public final class ErrorLogUtil {

    private static Map<Integer, String> errorMap = new LinkedHashMap<>();

    private final String correctOrExists = " must be correct or already exists in database";

    public ErrorLogUtil(){
        refreshErrorMap();
    }

    public void refreshErrorMap() {
        errorMap.put(101, "Type name" + correctOrExists);
        errorMap.put(102, "Type image" + correctOrExists);
        errorMap.put(103, "Brand name" + correctOrExists);
        errorMap.put(104, "Model name" + correctOrExists);
        errorMap.put(105, "Can't add Brand to Model. Wrong Brand data");
    }

    public static String showError(Integer key){
        return "ERROR CODE (#" + key + "): " + errorMap.get(key) + ";";
    }
}
