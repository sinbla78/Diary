package com.example.diary.domain.user.exception;


import com.example.diary.global.error.handler.DiaryException;
import com.example.diary.global.error.handler.ErrorCode;

public class UserNotFoundException extends DiaryException {

    public static final DiaryException EXCEPTION = new UserNotFoundException();

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
