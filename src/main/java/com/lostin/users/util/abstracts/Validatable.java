package com.lostin.users.util.abstracts;

import com.lostin.users.exception.ValidationException;

import java.util.Optional;

public interface Validatable {
    void validate() throws ValidationException;
    Optional<String> getViolations();
}

