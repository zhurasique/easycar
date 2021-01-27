package com.api.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/base-service")
    public String baseServiceFallBack() {
        return "Service is down, try again later. ERROR CODE #101";
    }

    @GetMapping("/image-service")
    public String imageServiceFallBack() {
        return "Service is down, try again later. ERROR CODE #102";
    }

    @GetMapping("/advert-service")
    public String advertServiceFallBack() {
        return "Service is down, try again later. ERROR CODE #103";
    }
}
