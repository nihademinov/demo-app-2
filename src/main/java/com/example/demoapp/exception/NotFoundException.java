package com.example.demoapp.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 58432132465811L;

    private int errorCode = 404;

    public NotFoundException(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(Object param) {
        super(String.format("Record with '%s' was not found", param));
    }

    public NotFoundException() {
        super("Record was not found");
    }

    public NotFoundException(String message, Throwable ex) {
        super(message, ex);
    }
}
