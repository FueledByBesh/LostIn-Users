package com.lostin.users.validation;

import com.lostin.users.exception.ValidationException;
import com.lostin.users.model.core.Email;
import com.lostin.users.model.core.UserId;
import com.lostin.users.model.core.Username;
import org.junit.jupiter.api.Test;

public class ValidationTest {

    @Test
    void testUserId(){
        String userIdToTest = "18487572-2676-4b14-aa22-c05195069e88";
        try {
            UserId.from(userIdToTest);
        }catch (ValidationException e){
            System.out.println(e.getMessage());
            System.out.println("Not validated");
            return;
        }
        System.out.println("Validated");
    }

    @Test
    void testEmail(){
        String testEmail = "hello";
        try {
            new Email(testEmail);
        }catch (ValidationException e){
            System.out.println(e.getMessage());
            System.out.println("Not validated");
            return;
        }
        System.out.println("Validated");
    }

    @Test
    void validateUsername(){
        String testUsername = "FueledByBesh";
        try {
            new Username(testUsername);
        }catch (ValidationException e){
            System.out.println(e.getMessage());
            System.out.println("Not validated");
            return;
        }
        System.out.println("Validated");
    }
}
