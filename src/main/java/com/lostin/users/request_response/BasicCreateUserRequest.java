package com.lostin.users.request_response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record BasicCreateUserRequest(
        @NotBlank(message = "Email is required")
        @Email(message = "Email is not valid")
        String email,

        @NotBlank(message = "Username is required")
        @Size(min = 3, max = 20, message = "Username should be from 3 to 20 symbols")
        @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username can contain only letters, numbers and underscore")
        String username
) {
}
