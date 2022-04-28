package com.service.base.util;

import org.json.JSONException;
import org.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOG = LoggerFactory.getLogger(MultipartFileUtil.class);

    public static JSONObject postForEntity(MultipartFile multipartFile, RestTemplate restTemplate,
                                           String endpoint) throws JSONException {
        MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();

        File file = null;
        try {
            file = convert(multipartFile);
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
        bodyMap.add("image", new FileSystemResource(file));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(endpoint, requestEntity, String.class);

        file.delete();
        
        return new JSONObject(response.getBody());
    }

    public static File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        try (FileOutputStream fos = new FileOutputStream(convFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
        return convFile;
    }
}
