package com.lostin.users.util.Validation.username;

import com.lostin.users.exception.ValidationException;
import com.lostin.users.model.core.Username;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<ValidUsername, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            new Username(value).validate();
            return true;
        }catch (ValidationException e){
            return false;
        }
    }
}
