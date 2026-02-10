package com.lostin.users.model.core;

import com.lostin.users.exception.ValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.NotNull;

import java.util.Set;
import java.util.UUID;

public record UserId(
        @NotNull(message = "ID cannot be null")
        UUID value
) {
    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    public UserId {
        Set<ConstraintViolation<UserId>> violations = validator.validate(this);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<UserId> violation : violations) {
                sb.append(violation.getMessage()).append("; ");
            }
            throw new ValidationException("USER_ID_VALIDATION_ERROR", sb.toString());
        }
    }
}
