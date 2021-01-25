package com.service.advert.util;

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
        errorMap.put(101, "Type name" + correctOrExists);
    }

    public static String showError(Integer key){
        return "Error received from advert-service!\nERROR CODE (#" + key + "): " + errorMap.get(key) + ";";
    }
}
