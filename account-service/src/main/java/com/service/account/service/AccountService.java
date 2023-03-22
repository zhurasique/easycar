package com.service.account.service;

import com.service.account.entity.Account;
import com.service.account.exception.NoSuchElementFoundException;
import com.service.account.repository.AccountRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepo accountRepo;

    public Account findById(String id) {
        return accountRepo.findById(id).orElseThrow(() -> new NoSuchElementFoundException(id));
    }

    public Account save(Account account) {
        return accountRepo.save(account);
    }
}
