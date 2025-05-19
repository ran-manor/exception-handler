package com.example.stringcheck.controller;

import com.example.stringcheck.errorhandling.InputContainsNumberException;
import com.example.stringcheck.errorhandling.InputRequest;
import com.example.stringcheck.errorhandling.ErrorResponse;
import com.example.stringcheck.service.StringValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class StringCheckController {
    private final StringValidationService stringValidationService;

    @Autowired
    private StringCheckController(StringValidationService stringValidationService) {
        this.stringValidationService = stringValidationService;
    }

    @PostMapping("/check")
    public ResponseEntity<?> checkInput(@RequestBody InputRequest request) {
        stringValidationService.inputValidation(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
