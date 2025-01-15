package com.nomoreft.todoapp.todo.domain.exception;

public class TodoRegistrationRejectedException extends TodoException {

        public TodoRegistrationRejectedException(String format, Object... args) {
            super(String.format(format, args));
        }
}
