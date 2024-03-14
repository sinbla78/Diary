package com.example.diary.global.exection;

import com.example.diary.global.error.handler.DiaryException;
import com.example.diary.global.error.handler.ErrorCode;

public class InvalidJwtException extends DiaryException {
    public static final DiaryException EXCEPTION = new InvalidJwtException();

    private InvalidJwtException() {
        super(ErrorCode.INVALID_JWT);
    }
}