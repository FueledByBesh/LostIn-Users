package com.lostin.users.model.proxy;

import com.lostin.users.model.core.*;
import lombok.Builder;
import lombok.Getter;
import org.jspecify.annotations.Nullable;

import java.util.UUID;

@Builder
@Getter
public class UserProxy {

    private final UserId userId;
    private Email email;
    private Username username;
    private String avatarUri;

    @Nullable
    public UUID getIdAsUUID(){
        if(userId!=null){
            return userId.value();
        }
        return null;
    }

    @Nullable
    public String getEmailAsString(){
        if(email==null) return null;
        return email.value();
    }

    @Nullable
    public String getUsernameAsString(){
        if(username==null) return null;
        return username.value();
    }

}
