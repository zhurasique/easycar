package com.service.auth.client;

import com.service.auth.vo.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "account-service")
@RequestMapping("/api/account-service")
public interface AccountServiceClient {
    @GetMapping("/account/{id}")
    Account findById(@PathVariable String id);

    @PostMapping("/account")
    Account save(@RequestBody Account account);
}
