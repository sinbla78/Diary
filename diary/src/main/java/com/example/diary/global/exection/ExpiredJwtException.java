package com.example.diary.global.exection;

import com.example.diary.global.error.handler.DiaryException;
import com.example.diary.global.error.handler.ErrorCode;

public class ExpiredJwtException extends DiaryException {
    public static final DiaryException EXCEPTION = new ExpiredJwtException();

    private ExpiredJwtException() {
        super(ErrorCode.EXPIRED_JWT);
    }
}