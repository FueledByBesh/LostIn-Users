package com.lostin.users.request_response.user.request;

import com.lostin.users.util.validation.annotation.ValidUUID;

public record GetUserProfileRequest(
        @ValidUUID String userId
){}
