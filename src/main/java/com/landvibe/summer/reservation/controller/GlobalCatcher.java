package com.landvibe.summer.reservation.controller;

import com.landvibe.summer.reservation.dto.response.ErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalCatcher {
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErrorResult> handleException(Exception e) {
        ErrorResult errorResult = new ErrorResult("-1", e.getMessage());
        return new ResponseEntity<>(errorResult, HttpStatus.BAD_REQUEST);
    }
}
