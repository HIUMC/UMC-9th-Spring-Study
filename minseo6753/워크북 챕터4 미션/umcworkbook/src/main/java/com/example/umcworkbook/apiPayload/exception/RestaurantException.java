package com.example.umcworkbook.apiPayload.exception;

import com.example.umcworkbook.apiPayload.code.error.BaseErrorCode;

public class RestaurantException extends GeneralException {
    public RestaurantException(BaseErrorCode code) {
        super(code);
    }
}
