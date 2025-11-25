package com.example.umc9th.global.exception.handler;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import com.example.umc9th.global.exception.GeneralException;

public class StoreHandler extends GeneralException {
    public StoreHandler(BaseErrorCode code) {
        super(code);
    }
}
