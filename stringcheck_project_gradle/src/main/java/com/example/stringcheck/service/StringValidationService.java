package com.example.stringcheck.service;

import com.example.stringcheck.errorhandling.ApiException;
import com.example.stringcheck.errorhandling.ErrorResponse;
import com.example.stringcheck.errorhandling.InputContainsNumberException;
import com.example.stringcheck.errorhandling.InputRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StringValidationService {

    public void inputValidation(InputRequest request) {
        String input = request.getInput();
        if (input == null || input.trim().isEmpty()) {
            throw new ApiException(new ErrorResponse(400, "Invalid input"));
        }

        if (input.matches(".*\\d.*")) {
            throw new InputContainsNumberException("Input contains digits");
        }
    }
}
