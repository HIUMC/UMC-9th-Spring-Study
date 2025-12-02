package com.example.Chapter6.domain.mission.exception.code;

import com.example.Chapter6.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MissionErrorCode implements BaseErrorCode {

    NOT_FOUND(HttpStatus.NOT_FOUND,
            "MISSION404_1",
            "미션 조회에 실패했습니다"),
    ;

    private final HttpStatus httpStatus;
    private final String message;
    private final String code;
}
