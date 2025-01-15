package com.nomoreft.todoapp.support;


import com.nomoreft.todoapp.foundation.crypto.PasswordEncoder;

public class NoOpPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(String password) {
        return password;
    }

    @Override
    public boolean matches(String rawPassword, String encodedPassword) {
        return rawPassword.equals(encodedPassword);
    }

}
