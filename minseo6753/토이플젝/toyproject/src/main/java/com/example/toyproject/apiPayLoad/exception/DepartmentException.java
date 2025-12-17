package com.example.toyproject.apiPayLoad.exception;

import com.example.toyproject.apiPayLoad.code.error.BaseErrorCode;

public class DepartmentException extends GeneralException{
    public DepartmentException(BaseErrorCode code) {
        super(code);
    }
}
