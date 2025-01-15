package com.nomoreft.todoapp.user.application.service;

import com.nomoreft.todoapp.user.application.port.LoginAuthenticationPort;
import com.nomoreft.todoapp.user.application.usecase._1LoginUser;
import com.nomoreft.todoapp.user.domain.AuthToken;
import org.springframework.stereotype.Service;

@Service
public class LoginUserService implements _1LoginUser {

    private final LoginAuthenticationPort loginAuthenticator;

    LoginUserService(LoginAuthenticationPort loginAuthenticator) {
        this.loginAuthenticator = loginAuthenticator;
    }

    @Override
    public AuthToken login(String username, String password) {
        loginAuthenticator.authenticate(username, password);
        String accessToken = loginAuthenticator.generateAccessToken(username);
        String refreshToken = loginAuthenticator.generateRefreshToken(username);
        return new AuthToken(accessToken, refreshToken);
    }

}
