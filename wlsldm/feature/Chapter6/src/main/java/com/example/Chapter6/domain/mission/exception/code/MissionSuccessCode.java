package com.example.Chapter6.domain.mission.exception.code;

import com.example.Chapter6.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MissionSuccessCode implements BaseSuccessCode {

    FOUND(HttpStatus.OK,
            "MISSION200_1",
            "성공적으로 미션을 조회했습니다"),
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
