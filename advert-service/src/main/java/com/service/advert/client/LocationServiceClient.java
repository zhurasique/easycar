package com.service.advert.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "location-service")
@RequestMapping("/api/location-service")
public interface LocationServiceClient {
}
