package com.lostin.users.request_response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record FindByEmailRequest(
        @NotBlank
        @Email
        String email
) {
}
