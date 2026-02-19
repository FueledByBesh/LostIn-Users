package com.lostin.users.dto.user;

import com.lostin.users.model.core.Email;
import com.lostin.users.model.core.UserId;
import com.lostin.users.model.core.Username;
import lombok.Builder;


@Builder
public record UserProfile(
        UserId userId,
        Username username,
        Email email,
        String avatarUri
) {
}
