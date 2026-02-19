package com.lostin.users.request_response.user.request;

import com.lostin.users.util.validation.annotation.ValidEmail;
import com.lostin.users.util.validation.annotation.ValidUsername;

public record BasicCreateUserRequest(
        @ValidEmail
        String email,

        @ValidUsername
        String username
) {}
