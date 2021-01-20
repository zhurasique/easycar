package com.easy.car.util;

import java.util.LinkedHashMap;
import java.util.Map;

public final class ErrorLogUtil {

    private static Map<Integer, String> errorMap = new LinkedHashMap<>();


    public ErrorLogUtil(){
        refreshErrorMap();
    }

    public void refreshErrorMap() {
        errorMap.put(101, "Type name must be correct or already exists in database");
        errorMap.put(102, "Type image must be correct or already exists in database");
    }

    public static String showError(Integer key){
        return "ERROR CODE (#" + key + "): " + errorMap.get(key) + ";";
    }
}
