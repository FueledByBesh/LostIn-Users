package com.lostin.users.exception;

public class UnAuthorizedException extends ServerError {
    public UnAuthorizedException(String message) {
        super("UNAUTHORIZED",message);
    }
}
