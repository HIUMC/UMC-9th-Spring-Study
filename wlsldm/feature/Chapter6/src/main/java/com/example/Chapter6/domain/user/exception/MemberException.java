package com.example.Chapter6.domain.user.exception;

import com.example.Chapter6.global.apiPayload.code.BaseErrorCode;
import com.example.Chapter6.global.apiPayload.execption.GeneralException;

public class MemberException extends GeneralException {
    public MemberException(BaseErrorCode code) {
        super(code);
    }
}
