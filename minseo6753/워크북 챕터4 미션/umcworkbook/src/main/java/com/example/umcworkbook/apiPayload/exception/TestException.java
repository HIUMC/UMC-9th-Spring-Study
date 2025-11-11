package com.example.umcworkbook.apiPayload.exception;

import com.example.umcworkbook.apiPayload.code.BaseErrorCode;

public class TestException extends GeneralException {
    public TestException(BaseErrorCode code) {
        super(code);
    }
}
