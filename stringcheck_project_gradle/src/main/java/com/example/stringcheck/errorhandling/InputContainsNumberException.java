package com.example.stringcheck.errorhandling;

public class InputContainsNumberException extends RuntimeException {
    public InputContainsNumberException(String message) {
        super(message);
    }
}
