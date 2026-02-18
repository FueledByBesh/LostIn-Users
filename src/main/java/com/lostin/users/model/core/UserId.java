package com.lostin.users.model.core;

import com.lostin.users.exception.ValidationException;
import com.lostin.users.util.JakartaValidator;
import com.lostin.users.util.abstracts.Validatable;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public record UserId(
        @NotNull(message = "ID cannot be null")
        UUID value
) implements Validatable {

    @Override
    public void validate() throws ValidationException {
        this.getViolations().ifPresent(e->{
            throw new ValidationException("Validation error",e);
        });
    }

    @Override
    public Optional<String> getViolations() {
        Set<ConstraintViolation<UserId>> violations = JakartaValidator.validator.validate(this);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<UserId> violation : violations) {
                sb.append(violation.getMessage()).append("; ");
            }
            return Optional.of(sb.toString());
        }
        return Optional.empty();
    }
}
