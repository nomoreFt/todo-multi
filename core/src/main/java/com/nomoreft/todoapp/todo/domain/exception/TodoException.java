package com.nomoreft.todoapp.todo.domain.exception;

import com.nomoreft.todoapp.foundation.exception.SystemException;

public class TodoException extends SystemException {
    public TodoException(String format, Object... args) {
        super(format, args);
    }

    public TodoException(Throwable cause) {
        super(cause);
    }

    public TodoException(String message, Throwable cause) {
        super(message, cause);
    }
}
