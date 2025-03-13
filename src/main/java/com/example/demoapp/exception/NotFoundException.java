package com.example.demoapp.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {



    private int errorCode = 404;



    public NotFoundException(String message) {
        super(message);
    }


}
