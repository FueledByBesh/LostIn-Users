package com.lostin.users.model.core;

import com.lostin.users.exception.ValidationException;
import jakarta.validation.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record Email(
        @NotNull(message = "Email cannot be null")
        @NotBlank(message = "Email cannot be blank")
        @jakarta.validation.constraints.Email(message = "Email is not valid")
        String value
) {
    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    public Email{
        Set<ConstraintViolation<Email>> violations = validator.validate(this);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Email> violation : violations) {
                sb.append(violation.getMessage()).append("; ");
            }
            throw new ValidationException("EMAIL_VALIDATION_ERROR",sb.toString());
        }
    }
}
