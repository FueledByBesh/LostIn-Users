package com.lostin.users.service;

import com.lostin.users.exception.ConflictException;
import com.lostin.users.exception.ServiceResponseException;
import com.lostin.users.model.proxy.UserProxy;
import com.lostin.users.model.core.*;
import com.lostin.users.repository.UserRepository;
import com.lostin.users.request_response.FindByEmailRequest;
import com.lostin.users.request_response.GetUserIdResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserManagementService {

    private final UserRepository userRepository;

    /**
     * Creates a user; returns user id if successful
     */
    public UUID basicUserCreation(Email email, Username username) {
        if (userRepository.isEmailTaken(email)) {
            throw new ConflictException("EMAIL_TAKEN","Email is already registered, please try another one!");
        }

        UserProxy user = UserProxy.builder()
                .email(email)
                .username(username)
                .build();

        UserProxy proxy = userRepository.saveAndFlush(user);
        return proxy.getUserId().value();
    }


    /**
     * Gets user ID by email or throws exception
     */
    public GetUserIdResponse getUserIdByEmail(FindByEmailRequest request) {
        UserId id= userRepository.getIdByEmail(new Email(request.email()))
                .orElseThrow(()-> new ServiceResponseException(404,"USER_NOT_FOUND","Email not registered"));

        return new GetUserIdResponse(id.value());
    }

    public boolean isEmailTaken(Email email) {
        return userRepository.isEmailTaken(email);
    }


}
