package com.example.Chapter6.domain.test.exception;

import com.example.Chapter6.global.apiPayload.code.BaseErrorCode;
import com.example.Chapter6.global.apiPayload.execption.GeneralException;

public class TestException extends GeneralException {
    public TestException(BaseErrorCode code) {
        super(code);
    }
}
