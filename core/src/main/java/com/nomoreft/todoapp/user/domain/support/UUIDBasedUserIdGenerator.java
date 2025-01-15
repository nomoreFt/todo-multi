package com.nomoreft.todoapp.user.domain.support;

import com.nomoreft.todoapp.shared.identifier.UserId;
import com.nomoreft.todoapp.user.domain.UserIdGenerator;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
class UUIDBasedUserIdGenerator implements UserIdGenerator {

    @Override
    public UserId generateId() {
        return UserId.of(UUID.randomUUID().toString());
    }

}
