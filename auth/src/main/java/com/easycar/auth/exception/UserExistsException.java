package com.easycar.auth.exception;

import lombok.Getter;

@Getter
public class UserExistsException extends RuntimeException {
    private final String reason;

    public UserExistsException(String username) {
        reason = String.format("User with username '%s' already exists!", username);
    }

    @Override
    public String getMessage() {
        return getReason();
    }
}

