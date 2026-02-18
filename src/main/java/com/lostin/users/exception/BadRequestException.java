package com.lostin.users.exception;

public class BadRequestException extends ServerError {
    public BadRequestException(String error,String message) {
        super(error,message);
    }
}
