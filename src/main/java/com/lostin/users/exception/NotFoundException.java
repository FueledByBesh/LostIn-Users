package com.lostin.users.exception;

public class NotFoundException extends ServerError {
    public NotFoundException(String message) {
        super("NOT_FOUND",message);
    }
}
