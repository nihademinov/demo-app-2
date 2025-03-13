package com.example.demoapp.exception;

import java.io.Serial;

public class AlreadyExistsException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 58432132465911L;

    public AlreadyExistsException(String message) {
        super(message);
    }

    public AlreadyExistsException(Object param) {
        super(String.format("Record with '%s' already exists", param));
    }

    public AlreadyExistsException() {
        super("Record already exists");
    }

    public AlreadyExistsException(String message, Throwable ex) {
        super(message, ex);
    }


}