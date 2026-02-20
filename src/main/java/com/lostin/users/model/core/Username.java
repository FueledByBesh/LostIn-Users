package com.lostin.users.model.core;

import com.lostin.users.exception.ValidationException;
import com.lostin.users.util.JakartaValidator;
import com.lostin.users.util.validation.annotation.ValidUsername;
import jakarta.validation.ConstraintViolation;

import java.util.Set;

public record Username(
        @ValidUsername
        String value
) {

    public Username(
            String value
    ) {
        this.value = value;
        Set<ConstraintViolation<Username>> violations = JakartaValidator.validator.validate(this);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Username> violation : violations) {
                sb.append(violation.getMessage()).append("; ");
            }
            throw new ValidationException("Validation Error",sb.toString());
        }
    }

}
