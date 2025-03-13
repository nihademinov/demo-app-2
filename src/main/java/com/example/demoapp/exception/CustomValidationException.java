package com.example.demoapp.exception;

import lombok.Getter;

@Getter
public class CustomValidationException extends RuntimeException {

    public CustomValidationException(String message) {
        super(message);
    }
}
