package com.service.advert;

import com.service.advert.util.ErrorLogUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AdvertServiceApplication {

    public static void main(String[] args) {
        new ErrorLogUtil();
        SpringApplication.run(AdvertServiceApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
