package com.lostin.users.request_response.user.request;

import com.lostin.users.util.validation.annotation.ValidEmail;

public record FindByEmailRequest(
        @ValidEmail
        String email
) {
}
