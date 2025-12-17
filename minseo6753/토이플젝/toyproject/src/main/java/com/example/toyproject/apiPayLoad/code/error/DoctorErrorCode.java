package com.example.toyproject.apiPayLoad.code.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum DoctorErrorCode implements BaseErrorCode {

    NOT_FOUND(HttpStatus.NOT_FOUND,
            "DOCTOR404_1",
            "해당 의사를 찾지 못했습니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
