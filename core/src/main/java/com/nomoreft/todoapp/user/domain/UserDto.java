package com.nomoreft.todoapp.user.domain;

import com.nomoreft.todoapp.shared.identifier.UserId;

public record UserDto(
        UserId id,
        UserName name
) {
}
