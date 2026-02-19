package com.lostin.users.model.core;

import com.lostin.users.exception.ValidationException;
import com.lostin.users.util.JakartaValidator;
import com.lostin.users.util.validation.annotation.ValidUUID;
import jakarta.validation.ConstraintViolation;
import lombok.Getter;
import lombok.NonNull;

import java.util.Set;
import java.util.UUID;

public class UserId{

    private final UUID value;

    public UserId(@ValidUUID(message = "Invalid User ID") String value) {
        try {
            this.value = UUID.fromString(value);
        }catch (IllegalArgumentException e){
            throw new ValidationException("Validation Error","Invalid User ID");
        }
        Set<ConstraintViolation<UserId>> violations = JakartaValidator.validator.validate(this);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<UserId> violation : violations) {
                sb.append(violation.getMessage()).append("; ");
            }
            throw new ValidationException("Validation Error",sb.toString());
        }
    }

    public UserId(UUID value) {
        if(value == null){
            throw new ValidationException("Validation Error","Invalid User ID");
        }
        this.value = value;
    }

    public UUID value(){
        return value;
    }

}
