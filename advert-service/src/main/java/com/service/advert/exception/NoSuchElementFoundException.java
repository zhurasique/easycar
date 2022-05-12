package com.service.advert.exception;

import lombok.Getter;

@Getter
public class NoSuchElementFoundException extends RuntimeException {
    private final String reason;

    public NoSuchElementFoundException(String keyword) {
        reason = String.format("No such element found using keyword %s", keyword);
    }

    @Override
    public String getMessage() {
        return getReason();
    }
}
