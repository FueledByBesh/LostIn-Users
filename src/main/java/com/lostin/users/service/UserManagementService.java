package com.lostin.users.service;

import com.lostin.users.exception.ServiceResponseException;
import com.lostin.users.exception.ValidationException;
import com.lostin.users.model.proxy.UserProxy;
import com.lostin.users.model.core.*;
import com.lostin.users.repository.UserRepository;
import com.lostin.users.request_response.BasicCreateUserRequest;
import com.lostin.users.request_response.BasicCreateUserResponse;
import com.lostin.users.request_response.FindByEmailRequest;
import com.lostin.users.request_response.GetUserIdResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserManagementService {

    private final UserRepository userRepository;

    /**
     * Creates a user; returns user id if successful
     */
    public BasicCreateUserResponse basicUserCreation(BasicCreateUserRequest request) {
        Email email = new Email(request.email());
        Username username = new Username(request.username());

        if (userRepository.isEmailTaken(email)) {
            throw new ServiceResponseException(409, "EMAIL_TAKEN", "Email is already registered, please try another one!");
        }

        UserProxy user = UserProxy.builder()
                .email(email)
                .username(username)
                .build();

        UserProxy proxy = userRepository.saveAndFlush(user);
        return new BasicCreateUserResponse(proxy.getUserId().value());
    }


    /**
     * Gets user ID by email or throws exception
     */
    public GetUserIdResponse getUserIdByEmail(FindByEmailRequest request) {
        UserId id= userRepository.getIdByEmail(new Email(request.email()))
                .orElseThrow(()-> new ServiceResponseException(404,"USER_NOT_FOUND","Email not registered"));

        return new GetUserIdResponse(id.value());
    }

    public boolean isEmailTaken(FindByEmailRequest request) {
        return userRepository.isEmailTaken(new Email(request.email()));
    }


}
