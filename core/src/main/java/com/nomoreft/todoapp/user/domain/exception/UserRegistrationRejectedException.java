package com.nomoreft.todoapp.user.domain.exception;

import com.nomoreft.todoapp.todo.domain.exception.TodoException;

public class UserRegistrationRejectedException extends TodoException {

        public UserRegistrationRejectedException(String format, Object... args) {
            super(String.format(format, args));
        }
}
