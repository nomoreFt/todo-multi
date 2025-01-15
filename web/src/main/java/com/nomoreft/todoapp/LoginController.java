package com.nomoreft.todoapp;

import com.nomoreft.todoapp.support.PermitWithoutJWTToken;
import com.nomoreft.todoapp.user.application.usecase._1LoginUser;
import com.nomoreft.todoapp.user.domain.AuthToken;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/guest/auth")
public class LoginController {

    private final _1LoginUser _1loginUser;

    public LoginController(_1LoginUser loginUser) {
        _1loginUser = loginUser;
    }

    @PermitWithoutJWTToken
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {
        AuthToken loginToken = _1loginUser.login(authenticationRequest.username(), authenticationRequest.password());

        return ResponseEntity.ok(new AuthenticationResponse(loginToken.accessToken(), loginToken.refreshToken()));
    }
    /* record classes */

    /**
     * 사용자 인증 요청을 위한 데이터 모델
     */
    public record AuthenticationRequest(
            @Schema(description = "사용자명", example = "admin@planitsquare.com") String username,
            @Schema(description = "비밀번호", example = "admin0801!") String password) {
    }

    /**
     * 사용자 인증 응답을 위한 데이터 모델
     */
    public record AuthenticationResponse(
            @Schema(description = "JWT 액세스 토큰", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...") String accessToken,
            @Schema(description = "JWT 리프레시 토큰", example = "dGhpcyBpcyBhIHNhbXBsZSBwYXlsb2FkLg==") String refreshToken) {
    }

    /**
     * 토큰 갱신 요청을 위한 데이터 모델
     */
    public record TokenRefreshRequest(
            @Schema(description = "리프레시 토큰", example = "dGhpcyBpcyBhIHNhbXBsZSBwYXlsb2FkLg==") String refreshToken) {
    }

    /**
     * 토큰 갱신 응답을 위한 데이터 모델
     */
    public record TokenRefreshResponse(
            @Schema(description = "새로운 JWT 액세스 토큰", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...") String accessToken) {
    }
}
