package com.nomoreft.todoapp.user.domain.event;

import com.nomoreft.todoapp.shared.identifier.UserId;
import com.nomoreft.todoapp.user.domain.UserName;

public record UserPayload(
        UserId id,
        UserName name
) {
}
