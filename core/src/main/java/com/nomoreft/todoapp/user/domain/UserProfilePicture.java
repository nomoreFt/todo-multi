package com.nomoreft.todoapp.user.domain;

import com.nomoreft.todoapp.shared.domain.ValueObject;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
import lombok.Getter;

import java.io.Serializable;
import java.net.URI;
import java.util.Objects;

@Getter
@Embeddable
public class UserProfilePicture extends ValueObject<UserProfilePicture> implements Serializable {

    private URI uri;

    private UserProfilePicture(URI uri) {
        Objects.requireNonNull(uri, "uri must be not null");
        this.uri = uri;
    }

    public static UserProfilePicture of(URI uri) {
        return new UserProfilePicture(uri);
    }

    @SuppressWarnings("unused")
    protected UserProfilePicture() {}

    @Override
    @Transient
    protected Object[] getEqualityFields() {
        return new Object[]{uri};
    }

}