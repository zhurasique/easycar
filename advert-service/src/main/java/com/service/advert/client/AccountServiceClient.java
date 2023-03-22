package com.service.advert.client;

import com.service.advert.vo.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "account-service")
@RequestMapping("/api/account-service")
public interface AccountServiceClient {
    @GetMapping("/account/{id}")
    Account findById(@PathVariable String id);
}
