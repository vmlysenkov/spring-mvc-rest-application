package com.lysenkov.phoneBookSpringMVC.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(ContactsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleCustomException(ContactsException ce) {
        return new ErrorResponse(ce.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now());
    }
}