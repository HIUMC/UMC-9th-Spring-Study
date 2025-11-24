package com.example.Chapter6.domain.store.exception.code;

import com.example.Chapter6.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum StoreSuccessCode implements BaseErrorCode {
    FOUND(HttpStatus.OK,
            "REVIEW200_1",
            "성공적으로 가게를 조회했습니다"),
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
