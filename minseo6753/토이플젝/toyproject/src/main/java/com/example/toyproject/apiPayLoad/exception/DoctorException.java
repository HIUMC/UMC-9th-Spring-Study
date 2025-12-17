package com.example.toyproject.apiPayLoad.exception;

import com.example.toyproject.apiPayLoad.code.error.BaseErrorCode;

public class DoctorException extends GeneralException{
    public DoctorException(BaseErrorCode code) {
        super(code);
    }
}
