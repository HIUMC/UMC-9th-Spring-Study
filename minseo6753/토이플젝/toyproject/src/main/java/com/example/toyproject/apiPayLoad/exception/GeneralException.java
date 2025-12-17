package com.example.toyproject.apiPayLoad.exception;

import com.example.toyproject.apiPayLoad.code.error.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private final BaseErrorCode code;
}
