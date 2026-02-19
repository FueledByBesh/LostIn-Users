package com.lostin.users.model.core;

import com.lostin.users.exception.ValidationException;
import com.lostin.users.util.JakartaValidator;
import com.lostin.users.util.validation.annotation.ValidUUID;
import jakarta.validation.ConstraintViolation;

import java.util.Set;
import java.util.UUID;

public record UserId(
        UUID value
) {

    public UserId(@ValidUUID(message = "Invalid User ID") UUID value) {
        this.value = value;
        Set<ConstraintViolation<UserId>> violations = JakartaValidator.validator.validate(this);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<UserId> violation : violations) {
                sb.append(violation.getMessage()).append("; ");
            }
            throw new ValidationException("Validation Error",sb.toString());
        }
    }

}
