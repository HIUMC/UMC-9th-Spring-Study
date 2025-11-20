package hello.umc9th.domain.mission.exception.code;

import hello.umc9th.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MissionErrorCode implements BaseErrorCode {

    NOT_FOUND(HttpStatus.NOT_FOUND, "MISSION404_1", "해당 미션을 찾을 수 없습니다."),
    ALREADY_CHALLENGED(HttpStatus.BAD_REQUEST, "MISSION400_1", "이미 도전 중인 미션입니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
