package com.example.diary.global.error.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND(404, "유저를 찾을 수 없습니다."),
    NOT_MATCHES_PASSWORD(400, "비밀번호가 올바르지 않습니다."),

    EXPIRED_JWT(401, "토큰이 만료되었습니다."),
    INVALID_JWT(401, "토큰이 유효하지 않습니다.");

    private final int status;
    private final String message;
}