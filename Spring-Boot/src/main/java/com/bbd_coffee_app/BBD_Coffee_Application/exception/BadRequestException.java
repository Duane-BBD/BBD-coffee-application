package com.bbd_coffee_app.BBD_Coffee_Application.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
