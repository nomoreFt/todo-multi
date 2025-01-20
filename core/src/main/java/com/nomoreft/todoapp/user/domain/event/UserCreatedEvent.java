package com.nomoreft.todoapp.user.domain.event;

import com.nomoreft.todoapp.shared.event.ApplicationEvent;
import com.nomoreft.todoapp.shared.identifier.UserId;
import com.nomoreft.todoapp.user.domain.UserName;

public class UserCreatedEvent extends UserEvent {
    public UserCreatedEvent(UserId id, UserName name, String email) {
        super(new UserPayload(id, name, email));
    }
}
