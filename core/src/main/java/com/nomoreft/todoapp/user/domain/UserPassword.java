package com.nomoreft.todoapp.user.domain;

import com.nomoreft.todoapp.foundation.crypto.PasswordEncoder;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.Objects;


@Getter
@Embeddable
public class UserPassword {

    private String encryptedPassword; // 암호화된 비밀번호만 저장

    @SuppressWarnings("unused")
    protected UserPassword() {}

    private UserPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public static UserPassword fromRawPassword(String rawPassword, PasswordEncoder passwordEncoder) {
        if (Objects.isNull(rawPassword) || rawPassword.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        if (!isValidPassword(rawPassword)) {
            throw new IllegalArgumentException("Password does not meet complexity requirements");
        }
        return new UserPassword(passwordEncoder.encode(rawPassword));
    }

    public static UserPassword fromEncryptedPassword(String encryptedPassword) {
        if (Objects.isNull(encryptedPassword) || encryptedPassword.trim().isEmpty()) {
            throw new IllegalArgumentException("Encrypted password cannot be null or empty");
        }
        return new UserPassword(encryptedPassword);
    }

    public boolean matches(String rawPassword, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(rawPassword, this.encryptedPassword);
    }

    private static boolean isValidPassword(String password) {
        return password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[a-z].*") &&
                password.matches(".*\\d.*");
    }

    @Override
    public String toString() {
        return "********";
    }
}