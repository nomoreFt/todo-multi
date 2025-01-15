package com.nomoreft.todoapp.web.jwt;

import com.nomoreft.todoapp.foundation.exception.NotImplementedException;
import com.nomoreft.todoapp.user.application.port.LoginAuthenticationPort;
import com.nomoreft.todoapp.web.jwt.support.JwtTokenUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Component;

@Component
public class LoginAuthenticationAdapter implements LoginAuthenticationPort {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    public LoginAuthenticationAdapter(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public void authenticate(String username, String password) {
/*        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );*/
        throw new NotImplementedException();
    }

    @Override
    public String generateAccessToken(String username) {
/*        return jwtTokenUtil.generateAccessToken(username);*/
        throw new NotImplementedException();
    }

    @Override
    public String generateRefreshToken(String username) {
/*        return jwtTokenUtil.generateRefreshToken(username);*/
        throw new NotImplementedException();
    }
}
