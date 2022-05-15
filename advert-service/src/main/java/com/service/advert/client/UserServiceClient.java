package com.service.advert.client;

import com.service.advert.vo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "user-service")
@RequestMapping("/api/user-service")
public interface UserServiceClient {
    @GetMapping("/user/{id}")
    User findById(@PathVariable String id);
}
