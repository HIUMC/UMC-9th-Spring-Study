package com.example.toyproject.apiPayLoad.exception;

import com.example.toyproject.apiPayLoad.code.error.BaseErrorCode;

public class ReservationException extends GeneralException{
    public ReservationException(BaseErrorCode code) {
        super(code);
    }
}
