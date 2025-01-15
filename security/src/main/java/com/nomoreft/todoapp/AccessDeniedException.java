package com.nomoreft.todoapp;

import com.nomoreft.todoapp.foundation.exception.SystemException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class AccessDeniedException extends SystemException {

    public AccessDeniedException() {
        super("Access denied: insufficient permissions to access the resource");
    }

}
