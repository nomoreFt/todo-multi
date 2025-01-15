package com.nomoreft.todoapp;

import com.nomoreft.todoapp.foundation.exception.SystemException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedAccessException extends SystemException {

    public UnauthorizedAccessException() {
        super("Unauthorized access: You must be authenticated to access this resource");
    }

}
