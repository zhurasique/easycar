package com.service.auth.client;

import com.service.auth.vo.Account;
import com.service.auth.vo.AccountWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "account-service")
@RequestMapping("/account")
public interface AccountServiceClient {

    @RequestMapping(path = "/", method = RequestMethod.POST)
    Account save(@RequestBody AccountWrapper accountWrapper);
}
