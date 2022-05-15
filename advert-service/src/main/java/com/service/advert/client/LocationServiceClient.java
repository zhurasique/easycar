package com.service.advert.client;

import com.service.advert.vo.Location;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "location-service")
@RequestMapping("/api/location-service")
public interface LocationServiceClient {
    @PostMapping("/location")
    Location saveLocation(@RequestBody Location location);

    @DeleteMapping("/location/{id}")
    void deleteLocation(@PathVariable String id);

    @PutMapping("/location/{id}")
    Location updateLocation(@PathVariable String id, Location newData);
}
