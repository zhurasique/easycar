package com.easy.car.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class ErrorLogUtil {

    private static Map<Integer, String> errorMap = new LinkedHashMap<>();

    public ErrorLogUtil(){
        refreshErrorMap();
    }

    public void refreshErrorMap() {
        errorMap.put(100, "Data already exists at database");
    }

    public static String showError(Integer key){
        return "ERROR CODE (#" + key + "): " + errorMap.get(key) + ";";
    }
}
