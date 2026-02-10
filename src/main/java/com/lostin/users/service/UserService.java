package com.lostin.users.service;


import com.lostin.users.model.core.UserId;
import com.lostin.users.model.proxy.UserProxy;
import com.lostin.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Nullable
    public UserProxy getUser(UUID userId) {
        return userRepository.findUserById(new UserId(userId)).orElse(null);
    }

    public UserProxy getUserOrThrow(UUID userId) {
        return userRepository.findUserById(new UserId(userId))
                .orElseThrow(() -> new RuntimeException("User not found"));
    }


}
