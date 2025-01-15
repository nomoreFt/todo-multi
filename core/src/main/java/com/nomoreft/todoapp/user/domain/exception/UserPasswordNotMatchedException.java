package com.nomoreft.todoapp.user.domain.exception;

public class UserPasswordNotMatchedException extends UserException {

    public UserPasswordNotMatchedException() {
        super("entered password does not match");
    }

}
