package com.nomoreft.todoapp.user.application;

import com.nomoreft.todoapp.shared.event.ApplicationEvent;
import com.nomoreft.todoapp.shared.identifier.UserId;

public class UserCreatedEvent extends ApplicationEvent<UserId> {

    public UserCreatedEvent(UserId userId) {
        super(userId);
    }
}
