package com.lostin.users.util.abstracts;

import com.lostin.users.exception.BadRequestException;

public interface ValidateRequest {
    void validate() throws BadRequestException;
}
