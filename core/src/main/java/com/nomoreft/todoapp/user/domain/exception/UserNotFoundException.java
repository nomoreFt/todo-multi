package com.nomoreft.todoapp.user.domain.exception;

public class UserNotFoundException extends UserException {

    private final String username;

    public UserNotFoundException(String username) {
        super(String.format("user not found (username: %s)", username));
        this.username = username;
    }

    @Override
    public Object[] getArguments() {
        return new Object[]{String.valueOf(username)};
    }

}
