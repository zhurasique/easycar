package com.service.base.util;

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
        errorMap.put(102, "Type image URL" + correctOrExists);
        errorMap.put(103, "Brand name" + correctOrExists);
        errorMap.put(104, "Model name" + correctOrExists);
        errorMap.put(105, "Can't add Brand to Model. Wrong or empty Brand data");
        errorMap.put(106, "Can't add Type to TypeModel. Wrong or empty Type data");
        errorMap.put(107, "Can't add Model to TypeModel. Wrong or empty Model data");
        errorMap.put(108, "Pair Type and Model" + exists);
        errorMap.put(109, "Generation name" + correct);
        errorMap.put(110, "Generation years" + correct);
        errorMap.put(111, "Generation model" + correct);
        errorMap.put(112, "Equipment name" + correctOrExists);
        errorMap.put(113, "Image" + correct);
        errorMap.put(114, "Engine capacity" + exists);
        errorMap.put(115, "Power" + correctOrExists);
        errorMap.put(116, "Color color" + correctOrExists);
        errorMap.put(117, "Color pattern" + correctOrExists);
        errorMap.put(118, "Fuel name" + correctOrExists);
        errorMap.put(119, "Transmission name" + correctOrExists);
    }

    public static String showError(Integer key){
        return "Error received from base-service!\nERROR CODE (#" + key + "): " + errorMap.get(key) + ";";
    }
}
