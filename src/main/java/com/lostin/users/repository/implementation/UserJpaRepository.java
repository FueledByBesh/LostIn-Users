package com.lostin.users.repository.implementation;

import com.lostin.users.model.entity.UserEntity;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<@NonNull UserEntity, @NonNull UUID> {

    Optional<UserEntity> findByEmail(@NonNull String email);
    boolean existsByEmail(@NonNull String email);

    @Query("SELECT u.id FROM UserEntity u WHERE u.email = ?1")
    Optional<UUID> findIdByEmail(@NonNull String email);

    @Query("SELECT u FROM UserEntity u WHERE u.id IN :ids")
    List<UserEntity> findAllByIds(List<UUID> ids);
}
