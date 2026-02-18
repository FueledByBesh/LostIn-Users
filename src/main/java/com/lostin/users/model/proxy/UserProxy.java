package com.lostin.users.model.proxy;

import com.lostin.users.model.core.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Builder
@Getter
public class UserProxy {

    private final UserId userId;
    private Email email;
    private Username username;

}
