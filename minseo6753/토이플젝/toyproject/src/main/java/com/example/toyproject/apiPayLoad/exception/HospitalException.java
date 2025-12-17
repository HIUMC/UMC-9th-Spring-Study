package com.example.toyproject.apiPayLoad.exception;

import com.example.toyproject.apiPayLoad.code.error.BaseErrorCode;

public class HospitalException extends GeneralException{
    public HospitalException(BaseErrorCode code) {
        super(code);
    }
}
