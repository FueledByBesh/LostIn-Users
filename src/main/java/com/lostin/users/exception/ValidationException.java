package com.lostin.users.exception;

public class ValidationException extends ServerError {
    public ValidationException(String error,String message) {
        super(error,message);
    }
}
