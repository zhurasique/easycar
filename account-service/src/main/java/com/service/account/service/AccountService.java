package com.service.account.service;

import com.service.account.client.AuthServiceClient;
import com.service.account.entity.Account;
import com.service.account.exception.AccountExistsException;
import com.service.account.exception.NoSuchElementFoundException;
import com.service.account.repository.AccountRepo;
import com.service.account.vo.AccountWrapper;
import com.service.account.vo.AuthProvider;
import com.service.account.vo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepo accountRepo;
    private final AuthServiceClient authServiceClient;

    public Optional<Account> findById(String id) {
        return accountRepo.findById(id);
    }

    public Account findByPrincipal(Principal principal) {
        return accountRepo.findById(principal.getName()).orElseThrow(
                () -> new NoSuchElementFoundException(principal.getName()));
    }

    @Transactional
    public Account save(AccountWrapper accountWrapper) {
        String username = accountWrapper.getUser().getUsername();
        Optional<Account> accountInRepo = accountRepo.findById(username);
        if (accountInRepo.isPresent()) {
            throw new AccountExistsException(username);
        }
        if (!authServiceClient.isUserExists(accountWrapper.getUser().getUsername()).isExists()) {
            User user = accountWrapper.getUser();
            user.setProvider(AuthProvider.local);
            authServiceClient.createUser(user);
        }
        return accountRepo.save(accountWrapper.getAccount());
    }
}
