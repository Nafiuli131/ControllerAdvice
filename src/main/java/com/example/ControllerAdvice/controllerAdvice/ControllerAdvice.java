package com.example.ControllerAdvice.controllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<NotFoundBody> handleNotFoundId(NoSuchElementException noSuchElementException){
        NotFoundBody notFoundBody = new NotFoundBody("Id Not Found",
                "001", LocalDateTime.now());
        return new ResponseEntity<>(notFoundBody, HttpStatus.NOT_FOUND);
    }
}
