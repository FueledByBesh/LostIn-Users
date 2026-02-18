package com.lostin.users.util;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class JakartaValidator {
    public static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    public static final Validator validator = factory.getValidator();
}
