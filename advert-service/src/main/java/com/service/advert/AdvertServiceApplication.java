package com.service.advert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AdvertServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdvertServiceApplication.class, args);
    }
}
