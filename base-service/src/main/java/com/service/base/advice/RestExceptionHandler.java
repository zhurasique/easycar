package com.service.base.advice;

import lombok.Builder;
import lombok.Data;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(IOException.class)
    public ResponseEntity<Response> handleIoException(IOException ex) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        Response response = Response.builder()
                .status(httpStatus.value())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(response, httpStatus);
    }

    @ExceptionHandler(JSONException.class)
    public ResponseEntity<Response> handleJsonException(JSONException ex) {
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
