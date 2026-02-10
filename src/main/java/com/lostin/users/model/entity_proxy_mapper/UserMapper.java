package com.lostin.users.model.entity_proxy_mapper;

import com.lostin.users.model.core.UserId;
import com.lostin.users.model.core.Username;
import com.lostin.users.model.entity.UserEntity;
import com.lostin.users.model.proxy.UserProxy;
import com.lostin.users.model.core.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserMapper {

    public UserProxy toProxy(UserEntity entity){
        return basicBuild(entity).build();
    }

    private UserProxy.UserProxyBuilder basicBuild(UserEntity entity){
        return UserProxy.builder()
                .userId(new UserId(entity.getId()))
                .email(new Email(entity.getEmail()))
                .username(new Username(entity.getUsername()));
    }


    public UserEntity toEntity(UserProxy proxy){
        return UserEntity.builder()
                .id(proxy.getUserId().value())
                .email(proxy.getEmail().value())
                .username(proxy.getUsername().value())
                .build();
    }

}
