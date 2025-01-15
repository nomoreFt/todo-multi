package com.nomoreft.todoapp.foundation.exception;

public class NotImplementedException extends SystemException {

    public NotImplementedException() {
        super("method is not yet implemented");
    }

    public NotImplementedException(String format, Object[] args) {
        super(format, args);
    }

}
