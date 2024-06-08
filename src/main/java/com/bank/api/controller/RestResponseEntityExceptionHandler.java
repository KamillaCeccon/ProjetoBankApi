package com.bank.api.controller;

import com.bank.api.exception.AccountNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {
    @ExceptionHandler(value
            = {AccountNotFound.class})
//    protected ResponseEntity<Void> handleConflict(
    protected ResponseEntity<Integer> handleConflict(
            RuntimeException ex, WebRequest request) {
        //return ResponseEntity.notFound().build();
        return new ResponseEntity<Integer>(0, HttpStatus.NOT_FOUND);

    }
}
