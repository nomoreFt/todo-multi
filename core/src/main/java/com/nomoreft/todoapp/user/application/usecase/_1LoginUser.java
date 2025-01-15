package com.nomoreft.todoapp.user.application.usecase;

import com.nomoreft.todoapp.user.domain.AuthToken;

public interface _1LoginUser {
   AuthToken login(String username, String password);
}
