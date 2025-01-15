package com.nomoreft.todoapp.foundation.crypto;

public interface PasswordEncoder {

    String encode(String password);

    boolean matches(String rawPassword, String encodedPassword);
}
