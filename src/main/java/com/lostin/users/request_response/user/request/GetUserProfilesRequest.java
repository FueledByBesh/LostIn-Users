package com.lostin.users.request_response.user.request;

import com.lostin.users.util.validation.annotation.ValidUUID;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record GetUserProfilesRequest (
        @NotEmpty(message = "user_ids cannot be empty")
        List<@ValidUUID String> userIds
){
}
