package com.example.Chapter6.domain.store.exception;

import com.example.Chapter6.global.apiPayload.code.BaseErrorCode;
import com.example.Chapter6.global.apiPayload.execption.GeneralException;

public class StoreException extends GeneralException {
    public StoreException(BaseErrorCode code) {
        super(code);
    }
}
