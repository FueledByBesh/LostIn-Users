package com.lostin.users.exception;

public class ConflictException extends ServerError {
    public ConflictException(String message) {
        super("CONFLICT",message);
    }
    public ConflictException(String error,String message) {
        super(error,message);
    }
}
