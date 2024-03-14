package com.example.diary.global.error.handler;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DiaryException extends RuntimeException {
    private final ErrorCode errorCode;
}
