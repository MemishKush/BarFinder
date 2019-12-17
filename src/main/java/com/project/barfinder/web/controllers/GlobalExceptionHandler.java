package com.project.barfinder.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({Throwable.class})
    public ResponseEntity handleException(Throwable e){
        String bodyOfResponse = e.getMessage();
        return ResponseEntity.status(500).body(bodyOfResponse);
    }
}
