package com.nomoreft.todoapp.user.application.usecase;

import com.nomoreft.todoapp.user.domain.User;
import com.nomoreft.todoapp.user.domain.UserName;
import com.nomoreft.todoapp.user.domain.exception.UserNotFoundException;
import com.nomoreft.todoapp.user.domain.exception.UserPasswordNotMatchedException;

public interface _6VerifyUserPassword {
    User verify(UserName username, String rawPassword) throws UserNotFoundException, UserPasswordNotMatchedException;
}
