package com.example.demoapp.exception;

public class OpenApiException extends RuntimeException {

    private static final long serialVersionUID = 5232132465811L;

    public OpenApiException() {
        super("Feign exception occurred");
    }

    public OpenApiException(String message) {
        super(message);
    }

    public OpenApiException(String message, Throwable ex) {
        super(message, ex);
    }
}