package com.example.demoapp.exception;

public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 58432131265811L;

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException() {
        super("User Not Found!");
    }

}
