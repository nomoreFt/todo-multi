package com.nomoreft.todoapp.user.domain.event;

import com.nomoreft.todoapp.shared.event.ApplicationEvent;
import lombok.Getter;

@Getter
public abstract class UserEvent extends ApplicationEvent<UserPayload> {
    protected UserEvent(UserPayload payload) {
        super(payload);
    }
}