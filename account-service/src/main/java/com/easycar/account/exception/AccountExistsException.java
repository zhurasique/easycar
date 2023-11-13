package com.easycar.account.exception;

import lombok.Getter;

@Getter
public class AccountExistsException extends RuntimeException {
    private final String reason;

    public AccountExistsException(String username) {
        reason = String.format("Account with username '%s' already exists!", username);
    }

    @Override
    public String getMessage() {
        return getReason();
    }
}

