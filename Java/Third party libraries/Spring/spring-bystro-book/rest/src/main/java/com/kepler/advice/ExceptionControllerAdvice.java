package com.kepler.advice;

import com.kepler.exception.NotEnoughMoneyException;
import com.kepler.model.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> exceprionNotEnouthMoneyHandler() {
        ErrorDetails errorDetails = 
                new ErrorDetails("Not enouth money for payment! Advice!!!");
        return ResponseEntity.badRequest().body(errorDetails);
    }
}
