package com.lostin.users.repository.implementation;

import com.lostin.users.model.entity.UserEntity;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<@NonNull UserEntity, @NonNull UUID> {

    Optional<UserEntity> findByEmail(@NonNull String email);
    boolean existsByEmail(@NonNull String email);
    Optional<UUID> findIdByEmail(@NonNull String email);
}
