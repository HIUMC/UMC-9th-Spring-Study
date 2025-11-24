package com.example.Chapter6.domain.review.exception.code;

import com.example.Chapter6.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ReviewErrorCode implements BaseErrorCode {
    NOT_FOUND(HttpStatus.NOT_FOUND,
            "REVIEW404_1",
            "리뷰 조회에 실패했습니다"),
    ;

    private final HttpStatus httpStatus;
    private final String message;
    private final String code;
}
