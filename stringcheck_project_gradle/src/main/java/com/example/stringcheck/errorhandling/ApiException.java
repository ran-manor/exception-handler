package com.example.stringcheck.errorhandling;

public class ApiException extends RuntimeException {
    protected ErrorResponse errorResponse;

    public ApiException(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }
}
