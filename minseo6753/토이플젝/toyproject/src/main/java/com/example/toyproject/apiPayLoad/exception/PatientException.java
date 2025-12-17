package com.example.toyproject.apiPayLoad.exception;

import com.example.toyproject.apiPayLoad.code.error.BaseErrorCode;

public class PatientException extends GeneralException{
    public PatientException(BaseErrorCode code) {
        super(code);
    }
}
