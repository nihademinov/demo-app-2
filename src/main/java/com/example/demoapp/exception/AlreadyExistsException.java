package com.example.demoapp.exception;

import java.io.Serial;

public class AlreadyExistsException extends RuntimeException {



    public AlreadyExistsException(String message) {
        super(message);
    }




}