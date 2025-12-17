package com.example.toyproject.apiPayLoad.code.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum HospitalErrorCode implements BaseErrorCode{

    NOT_FOUND(HttpStatus.NOT_FOUND,
            "HOSPITAL404_1",
            "해당 병원을 찾지 못했습니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
