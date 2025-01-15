package com.nomoreft.todoapp.todo.domain.exception;

public class TodoNotFoundException extends TodoException {

    public TodoNotFoundException(String format, Object... args) {
        super(String.format(format, args));
    }
}
