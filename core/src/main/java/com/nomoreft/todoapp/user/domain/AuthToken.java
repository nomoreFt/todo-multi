package com.nomoreft.todoapp.user.domain;

public record AuthToken(String accessToken, String refreshToken) {
}
