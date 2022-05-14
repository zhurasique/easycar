package com.service.base.exception;

import lombok.Getter;

@Getter
public class BusinessLogicException extends RuntimeException {
    private final String reason;

    public BusinessLogicException(String reason) {
        this.reason = reason;
    }

    @Override
    public String getMessage() {
        return getReason();
    }
}
