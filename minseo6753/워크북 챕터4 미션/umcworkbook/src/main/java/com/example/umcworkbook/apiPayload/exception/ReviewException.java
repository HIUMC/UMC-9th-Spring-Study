package com.example.umcworkbook.apiPayload.exception;

import com.example.umcworkbook.apiPayload.code.error.BaseErrorCode;

public class ReviewException extends GeneralException{
    public ReviewException(BaseErrorCode code) {
        super(code);
    }
}
