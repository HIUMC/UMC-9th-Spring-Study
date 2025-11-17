package com.example.umcworkbook.apiPayload.exception;

import com.example.umcworkbook.apiPayload.code.error.BaseErrorCode;

public class MissionException extends GeneralException{
    public MissionException(BaseErrorCode code) {
        super(code);
    }
}
