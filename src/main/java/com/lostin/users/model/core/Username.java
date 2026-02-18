package com.lostin.users.model.core;

import com.lostin.users.exception.ValidationException;
import com.lostin.users.util.JakartaValidator;
import com.lostin.users.util.abstracts.Validatable;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Optional;
import java.util.Set;

public record Username(
        @NotBlank(message = "Username required")
        @Size(min = 3, max = 20, message = "Username should be from 3 to 20 symbols")
        @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username can contain only letters, numbers and _")
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
        Set<ConstraintViolation<Username>> violations = JakartaValidator.validator.validate(this);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Username> violation : violations) {
                sb.append(violation.getMessage()).append("; ");
            }
            return Optional.of(sb.toString());
        }
        return Optional.empty();
    }
}
