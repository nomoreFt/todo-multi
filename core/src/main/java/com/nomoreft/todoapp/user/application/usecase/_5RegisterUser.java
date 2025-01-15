package com.nomoreft.todoapp.user.application.usecase;

import com.nomoreft.todoapp.user.domain.User;
import com.nomoreft.todoapp.user.domain.UserName;
import com.nomoreft.todoapp.user.domain.exception.UserRegistrationRejectedException;

public interface _5RegisterUser {

    User register(UserName username, String rawPassword) throws UserRegistrationRejectedException;
}
