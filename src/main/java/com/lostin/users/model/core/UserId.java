package com.lostin.users.model.core;

import com.lostin.users.exception.ValidationException;

import java.util.Objects;
import java.util.UUID;

public record UserId(
        UUID value
){

    public UserId {
        if (value == null) {
            throw new ValidationException("Validation Error", "Invalid User ID");
        }
    }

    public static UserId from(String value) {
        if(Objects.isNull(value) || value.isBlank()){
            throw new ValidationException("Validation Error","User ID cannot be null or blank");
        }
        UUID valueFromString;
        try {
            valueFromString = UUID.fromString(value);
        }catch (IllegalArgumentException e){
            throw new ValidationException("Validation Error","Invalid User ID");
        }
        return new UserId(valueFromString);
    }

}
