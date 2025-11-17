package com.example.umcworkbook.apiPayload.exception;

import com.example.umcworkbook.apiPayload.code.error.BaseErrorCode;

public class MemberException extends GeneralException {
    public MemberException(BaseErrorCode code) {
        super(code);
    }
}
