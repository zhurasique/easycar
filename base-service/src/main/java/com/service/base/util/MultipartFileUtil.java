package com.service.base.util;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public abstract class MultipartFileUtil {

    public static File convert(MultipartFile file) {
        File convFile = new File(file.getOriginalFilename());

        try {
            convFile.createNewFile();

            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return convFile;
    }

    public static JSONObject postForEntity(MultipartFile multipartFile, RestTemplate restTemplate, String endpoint) throws JSONException {
        MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
        bodyMap.add("image", new FileSystemResource(MultipartFileUtil.convert(multipartFile)));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(endpoint, requestEntity, String.class);

        return new JSONObject(response.getBody());
    }
}
