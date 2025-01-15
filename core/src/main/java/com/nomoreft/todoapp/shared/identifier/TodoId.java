package com.nomoreft.todoapp.shared.identifier;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TodoId implements Serializable {

    private String value;

    TodoId(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("todo-id is must not be null or empty");
        }
        this.value = value;
    }

    // for hibernate
    @SuppressWarnings("unused")
    protected TodoId() {}

    public static TodoId of(String value) {
        return new TodoId(value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        return Objects.equals(value, ((TodoId) obj).value);
    }

    @Override
    public String toString() {
        return value;
    }

}
