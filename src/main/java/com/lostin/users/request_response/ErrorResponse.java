package com.lostin.users.request_response;

public record ErrorResponse(
        String error,
        String message
) {}
