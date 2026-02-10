package com.lostin.users.exception;


import lombok.experimental.SuperBuilder;

@SuperBuilder
public class ValidationException extends ServerError {
    public ValidationException(String error,String message) {
        super(error,message);
    }
}
