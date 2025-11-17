package com.example.umc9th.global.exception.handler;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import com.example.umc9th.global.exception.GeneralException;

public class FoodHandler extends GeneralException {

    public FoodHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
