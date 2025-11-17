package com.example.Chapter6.domain.review.exception;

import com.example.Chapter6.global.apiPayload.code.BaseErrorCode;
import com.example.Chapter6.global.apiPayload.execption.GeneralException;

public class ReviewException extends GeneralException {
    public ReviewException(BaseErrorCode code) {
        super(code);
    }
}
