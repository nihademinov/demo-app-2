package com.example.demoapp.exception;


public class CustomRestClientException extends  RuntimeException{
    private String message;

    public CustomRestClientException() {}

    public CustomRestClientException(String msg) {
        super(msg);
        this.message = msg;
    }
}