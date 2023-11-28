package com.easycar.account.service;

import com.easycar.account.client.AuthServiceClient;
import com.easycar.account.entity.Account;
import com.easycar.account.exception.AccountExistsException;
import com.easycar.common.exception.NoSuchElementFoundException;
import com.easycar.account.repository.AccountRepo;
import com.easycar.account.vo.AccountWrapper;
import com.easycar.account.vo.AuthProvider;
import com.easycar.account.vo.User;
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
            user.setRoles(new String[]{"USER"});
            authServiceClient.createUser(user);
        }
        return accountRepo.save(accountWrapper.getAccount());
    }
}
