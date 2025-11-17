package com.example.umcworkbook.apiPayload.code.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum CategoryErrorCode implements BaseErrorCode {
    NOT_FOUND(HttpStatus.NOT_FOUND,
            "CATEGORY404_1" ,
            "해당 카테고리를 찾지 못했습니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
