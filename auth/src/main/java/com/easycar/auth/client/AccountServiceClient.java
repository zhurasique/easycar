package com.easycar.auth.client;

import com.easycar.auth.vo.Account;
import com.easycar.auth.vo.AccountWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@FeignClient(name = "account-service")
@RequestMapping("/account")
public interface AccountServiceClient {

    @RequestMapping(path = "/", method = RequestMethod.POST)
    Account save(@RequestBody AccountWrapper accountWrapper);

    @GetMapping("/{id}")
    Optional<Account> findById(@PathVariable String id);
}
