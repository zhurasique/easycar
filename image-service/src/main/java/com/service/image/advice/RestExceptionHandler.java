package com.service.image.advice;

import com.service.image.exception.NoSuchElementFoundException;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Response handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return Response.builder()
                .message(errors.toString())
                .dateTime(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(IOException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Response handleIoException(IOException ex) {
        return Response.builder()
                .message(ex.getMessage())
                .dateTime(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Response handleException(Exception ex) {
        return Response.builder()
                .message(ex.getMessage())
                .dateTime(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(NoSuchElementFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public Response handleNoSuchElementFoundException(NoSuchElementFoundException ex) {
        return Response.builder()
                .message(ex.getMessage())
                .dateTime(LocalDateTime.now())
                .build();
    }

    @Builder
    @Data
    private static class Response {
        private String message;
        private LocalDateTime dateTime;
    }
}
