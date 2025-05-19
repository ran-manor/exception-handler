package com.example.stringcheck.aspect;

import com.example.stringcheck.errorhandling.ApiException;
import com.example.stringcheck.errorhandling.ErrorResponse;
import com.example.stringcheck.errorhandling.InputContainsNumberException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InputContainsNumberException.class)
    public ResponseEntity<ErrorResponse> handleInputContainsNumberException(InputContainsNumberException ex) {
        ErrorResponse error = new ErrorResponse(10000, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleApiException(ApiException ex) {
        ErrorResponse error = new ErrorResponse(ex.getErrorResponse().getCode(), ex.getErrorResponse().getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
