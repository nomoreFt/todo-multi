package com.nomoreft.todoapp.todo.domain;

import com.nomoreft.todoapp.shared.domain.ValueObject;
import com.nomoreft.todoapp.todo.domain.exception.TodoRegistrationRejectedException;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;

import java.util.Objects;

@Embeddable
public class TodoText extends ValueObject<TodoText> {
    String text;

    private TodoText(String text) {
        if(Objects.isNull(text) || text.isEmpty() || text.trim().length() < 4) {
            throw new TodoRegistrationRejectedException("Text must be at least 4 characters long.");
        }
        this.text = text;
    }

    public static TodoText of(String text) {
        return new TodoText(text);
    }

    @SuppressWarnings("unused")
    protected TodoText() {}

    @Override
    @Transient
    protected Object[] getEqualityFields() {
        return new Object[]{text};
    }

    @Override
    public String toString() {
        return text;
    }
}
