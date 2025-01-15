package com.nomoreft.todoapp.user.domain;

import com.nomoreft.todoapp.shared.identifier.UserId;

public interface UserIdGenerator {

    UserId generateId();

}

