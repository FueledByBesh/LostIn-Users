package com.lostin.users.request_response.user.response;

import com.lostin.users.dto.user.UserProfile;

import java.util.UUID;

public record MinimalProfileWithIDResponse(
        UUID userId,
        String email,
        String username,
        String avatarUri
) {
    public static MinimalProfileWithIDResponse fromUserProfile(UserProfile profile){
        return new MinimalProfileWithIDResponse(
                profile.userId().value(),
                profile.email().value(),
                profile.username().value(),
                profile.avatarUri()
        );
    }
}
