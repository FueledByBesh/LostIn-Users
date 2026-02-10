package com.lostin.users.controller;


import com.lostin.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    //todo
    /*
    gets User id from token
     */
    @GetMapping("/get-min-data")
    protected ResponseEntity<@NonNull String> getMinData(

    ) {
        return ResponseEntity.ok("Not Implemented Yet!");
    }

    //todo
    //should check for client scopes
    @GetMapping("/get-full-data")
    protected ResponseEntity<@NonNull String> getFullData() {
        return ResponseEntity.ok("Not Implemented Yet!");
    }

    //todo
    @PostMapping("/delete")
    protected ResponseEntity<@NonNull String> deleteUser() {
        return ResponseEntity.ok("Not Implemented Yet!");
    }


}
