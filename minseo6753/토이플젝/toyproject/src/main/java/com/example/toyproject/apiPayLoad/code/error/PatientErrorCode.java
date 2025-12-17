package com.example.toyproject.apiPayLoad.code.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum PatientErrorCode implements BaseErrorCode {

    NOT_FOUND(HttpStatus.NOT_FOUND,
            "PATIENT404_1",
            "해당 환자를 찾지 못했습니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
