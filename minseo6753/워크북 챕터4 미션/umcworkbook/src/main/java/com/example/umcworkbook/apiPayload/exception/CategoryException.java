package com.example.umcworkbook.apiPayload.exception;

import com.example.umcworkbook.apiPayload.code.error.BaseErrorCode;

public class CategoryException extends GeneralException {

    public CategoryException(BaseErrorCode code) {
        super(code);
    }
}
