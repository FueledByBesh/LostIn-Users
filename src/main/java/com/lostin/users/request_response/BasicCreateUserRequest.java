package com.lostin.users.request_response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record BasicCreateUserRequest(
        @NotBlank
        @Email
        String email,

        @NotBlank(message = "Username обязателен")
        @Size(min = 3, max = 15, message = "Username должен быть от 3 до 15 символов")
        @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username может содержать только буквы, цифры и _")
        String username
) {
}
