package com.example.umcworkbook.apiPayload.exception;

import com.example.umcworkbook.apiPayload.code.error.BaseErrorCode;

public class MemberMissionException extends GeneralException {
    public MemberMissionException(BaseErrorCode code) {
        super(code);
    }
}
