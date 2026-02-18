package com.lostin.users.util.Validation.email;

import com.lostin.users.exception.ValidationException;
import com.lostin.users.model.core.Email;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            new Email(value).validate();
            return true;
        }catch (ValidationException e){
            return false;
        }
    }
}
