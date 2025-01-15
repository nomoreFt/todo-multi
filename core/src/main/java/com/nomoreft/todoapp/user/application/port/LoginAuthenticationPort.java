package com.nomoreft.todoapp.user.application.port;

public interface LoginAuthenticationPort {
    void authenticate(String username, String password);
    String generateAccessToken(String username);
    String generateRefreshToken(String username);
}