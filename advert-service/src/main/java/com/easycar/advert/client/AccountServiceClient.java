package com.easycar.advert.client;

import com.easycar.advert.vo.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@FeignClient(name = "account-service")
@RequestMapping("/account")
public interface AccountServiceClient {
    @GetMapping("/{id}")
    Optional<Account> findById(@PathVariable String id);
}
