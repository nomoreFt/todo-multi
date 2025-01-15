package com.nomoreft.todoapp.user.domain.exception;

import com.nomoreft.todoapp.foundation.exception.SystemException;

public class UserException extends SystemException {

    public UserException(String format, Object... args) {
        super(format, args);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

}
