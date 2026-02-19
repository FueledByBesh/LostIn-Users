package com.lostin.users.controller;


import com.lostin.users.model.core.Email;
import com.lostin.users.model.core.Username;
import com.lostin.users.request_response.*;
import com.lostin.users.service.UserManagementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


/*
API for management of all users
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    private final UserManagementService userManagementService;

    ///can be called only from auth service (Add @PreAuthorize from Spring Security)
    /// returns UserId (UUID) if the user created successfully, if not error with a message
    @PostMapping("/basic-create")
    protected ResponseEntity<@NonNull BasicCreateUserResponse> createUser(
            @Valid @RequestBody BasicCreateUserRequest request
    ) {
        UUID userId = userManagementService.basicUserCreation(
                new Email(request.email()),
                new Username(request.username())
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(new BasicCreateUserResponse(userId));
    }

    /*
     Always returns 200 ok with body "taken": boolean(true,false)
     */
    @PostMapping("/is-email-taken")
    protected ResponseEntity<@NonNull Boolean> isEmailTaken(
            @Valid @RequestBody FindByEmailRequest request
    ) {
        boolean taken = userManagementService.isEmailTaken(new Email(request.email()));
        return ResponseEntity.ok(taken);
    }

    /*
    returns 404 if the email is not registered
    if registered returns the user id with code 200
     */
    @PostMapping("/get-id-by-email")
    protected ResponseEntity<@NonNull GetUserIdResponse> getIdByEmail(
            @Valid @RequestBody FindByEmailRequest request
    ){
        var response = userManagementService.getUserIdByEmail(request);
        return ResponseEntity.ok(response);
    }

}
