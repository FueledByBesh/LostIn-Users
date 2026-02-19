package com.lostin.users.model.core;

import com.lostin.users.exception.ValidationException;
import com.lostin.users.util.JakartaValidator;
import com.lostin.users.util.validation.annotation.ValidEmail;
import jakarta.validation.*;

import java.util.Set;

public record Email(
        String value
) {

    public Email(
            @ValidEmail String value
    ){
        this.value = value;
        Set<ConstraintViolation<Email>> violations = JakartaValidator.validator.validate(this);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Email> violation : violations) {
                sb.append(violation.getMessage()).append("; ");
            }
            throw new ValidationException("Validation Error",sb.toString());
        }
    }

}
