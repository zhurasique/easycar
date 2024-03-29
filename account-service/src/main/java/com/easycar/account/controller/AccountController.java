package com.easycar.account.controller;

import com.easycar.account.entity.Account;
import com.easycar.account.service.AccountService;
import com.easycar.account.vo.AccountWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{id}")
    public Optional<Account> findById(@PathVariable String id) {
        return accountService.findById(id);
    }

    @GetMapping("/current")
    public Map<String, Object> findByPrincipal(Principal principal) {
        return accountService.findByPrincipal(principal);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Account save(@Valid @RequestBody AccountWrapper accountWrapper) {
        return accountService.save(accountWrapper);
    }
}
