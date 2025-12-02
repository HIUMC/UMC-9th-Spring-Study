package com.example.Chapter6.domain.store.exception.code;

import com.example.Chapter6.global.apiPayload.code.BaseErrorCode;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum StoreErrorCode implements BaseErrorCode {
    NOT_FOUND(HttpStatus.NOT_FOUND,
            "REVIEW404_1",
            "가게 조회에 실패했습니다"),
    ;

    private final HttpStatus httpStatus;
    private final String message;
    private final String code;
}
