package com.lostin.users.request_response.user.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.lostin.users.dto.user.UserProfile;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record MinimalProfileResponse(
        String email,
        String username,
        String avatarUri
) {
    public MinimalProfileResponse fromUserProfile(UserProfile profile){
        return new MinimalProfileResponse(
                profile.email().value(),
                profile.username().value(),
                profile.avatarUri()
        );
    }
}
