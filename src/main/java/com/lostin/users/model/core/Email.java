package com.lostin.users.model.core;

import com.lostin.users.exception.ValidationException;
import com.lostin.users.util.JakartaValidator;
import com.lostin.users.util.abstracts.Validatable;
import jakarta.validation.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Optional;
import java.util.Set;

public record Email(
        @NotBlank(message = "Email is required")
        @jakarta.validation.constraints.Email(message = "Email is not valid")
        String value
) implements Validatable {

    @Override
    public void validate() throws ValidationException {
        this.getViolations().ifPresent(e -> {
            throw new ValidationException("Validation Error",e);
        });
    }

    @Override
    public Optional<String> getViolations() {
        Set<ConstraintViolation<Email>> violations = JakartaValidator.validator.validate(this);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Email> violation : violations) {
                sb.append(violation.getMessage()).append("; ");
            }
            return Optional.of(sb.toString());
        }
        return Optional.empty();
    }
}
