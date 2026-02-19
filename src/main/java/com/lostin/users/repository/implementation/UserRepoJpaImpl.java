package com.lostin.users.repository.implementation;

import com.lostin.users.model.core.*;
import com.lostin.users.model.entity.UserEntity;
import com.lostin.users.model.entity_proxy_mapper.UserMapper;
import com.lostin.users.model.proxy.UserProxy;
import com.lostin.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Qualifier("jpa-impl")
@RequiredArgsConstructor
public class UserRepoJpaImpl implements UserRepository {

    private final UserJpaRepository repo;
    private final UserMapper mapper;

    @Override
    public Optional<UserProxy> findUserById(@NonNull UserId userId) {
        return repo.findById(userId.value()).map(mapper::toProxy);
    }

    @Override
    public Optional<UserProxy> findUserByEmail(@NonNull Username username) {
        return repo.findByEmail(username.value()).map(mapper::toProxy);
    }

    @Override
    public UserProxy save(@NonNull UserProxy user) {
        UserEntity result = repo.save(mapper.toEntity(user));
        return mapper.toProxy(result);
    }

    @Override
    public UserProxy saveAndFlush(@NonNull UserProxy user) {
        UserEntity entity = repo.saveAndFlush(mapper.toEntity(user));
        return mapper.toProxy(entity);
    }

    @Override
    public Boolean isEmailTaken(@NonNull Email email) {
        return repo.existsByEmail(email.value());
    }

    @Override
    public Optional<UserId> getIdByEmail(@NonNull Email email) {
        return repo.findIdByEmail(email.value()).map(UserId::new);
    }


}
