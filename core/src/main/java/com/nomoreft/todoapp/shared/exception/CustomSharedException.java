package com.nomoreft.todoapp.shared.exception;

import com.nomoreft.todoapp.foundation.exception.SystemException;

public class CustomSharedException extends SystemException {

    public CustomSharedException(String message) {
        super(message);
    }

    public CustomSharedException(String message, Throwable cause) {
        super(message, cause);
    }
}