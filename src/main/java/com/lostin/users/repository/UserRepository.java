package com.lostin.users.repository;

import com.lostin.users.dto.user.UserProfile;
import com.lostin.users.model.core.Email;
import com.lostin.users.model.core.UserId;
import com.lostin.users.model.core.Username;
import com.lostin.users.model.proxy.UserProxy;
import org.jspecify.annotations.NonNull;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<UserProxy> findUserById(@NonNull UserId userId);
    Optional<UserProxy> findUserByEmail(@NonNull Username username);
    UserProxy save(@NonNull UserProxy user);

    Optional<UserProfile> getUserProfile(@NonNull UserId userId);
    UserProxy saveAndFlush(@NonNull UserProxy user);
    Boolean isEmailTaken(@NonNull Email email);
    Optional<UserId> getIdByEmail(@NonNull Email email);
    List<UserProfile> getProfiles(@NonNull List<UserId> userIds);

}
