package com.service.image.util;

import java.util.LinkedHashMap;
import java.util.Map;

public final class ErrorLogUtil {

    private static Map<Integer, String> errorMap = new LinkedHashMap<>();

    private final String correctOrExists = " must be correct or already exists in database";
    private final String correct = " must be correct";
    private final String exists = " already exists in database";

    public ErrorLogUtil(){
        refreshErrorMap();
    }

    public void refreshErrorMap() {
        errorMap.put(101, "Image" + correct);
    }

    public static String showError(Integer key){
        return "Error received from image-service!\nERROR CODE (#" + key + "): " + errorMap.get(key) + ";";
    }
}
