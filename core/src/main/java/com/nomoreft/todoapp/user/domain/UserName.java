package com.nomoreft.todoapp.user.domain;

import com.nomoreft.todoapp.shared.domain.ValueObject;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
import lombok.Getter;

import java.util.Objects;

@Getter
@Embeddable
public class UserName extends ValueObject<UserName> {

    private String name;

    @SuppressWarnings("unused")
    protected UserName() {}

    private UserName(String name) {
        if (Objects.isNull(name) || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if (name.length() < 4) {
            throw new IllegalArgumentException("Username must be at least 4 characters long");
        }
        this.name = name;
    }

    public static UserName of(String name) {
        return new UserName(name);
    }

    @Override
    @Transient
    protected Object[] getEqualityFields() {
        return new Object[]{name};
    }
}