package com.lostin.users.controller;


import com.lostin.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/get-profile")
    protected ResponseEntity<@NonNull String> getProfile() {
        /*todo:
           Gets user Id from token
           Checks for scope
         */
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
