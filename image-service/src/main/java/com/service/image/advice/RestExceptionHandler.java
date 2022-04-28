package com.service.image.advice;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        Response response = Response.builder()
                .status(httpStatus.value())
                .message(errors.toString())
                .build();
        return new ResponseEntity<>(response, httpStatus);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<Response> handleIoException(IOException ex) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        Response response = Response.builder()
                .status(httpStatus.value())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(response, httpStatus);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleException(Exception ex) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        Response response = Response.builder()
                .status(httpStatus.value())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(response, httpStatus);
    }

    @Data
    @Builder
    private static class Response {
        private int status;
        private String message;
    }
}
