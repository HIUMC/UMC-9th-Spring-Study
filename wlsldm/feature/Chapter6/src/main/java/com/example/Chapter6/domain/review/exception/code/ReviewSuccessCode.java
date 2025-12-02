package com.example.Chapter6.domain.review.exception.code;

import com.example.Chapter6.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ReviewSuccessCode implements BaseSuccessCode {

    FOUND(HttpStatus.OK,
            "REVIEW200_1",
            "성공적으로 리뷰를 조회했습니다"),
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}

