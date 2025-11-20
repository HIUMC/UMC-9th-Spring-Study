package hello.umc9th.domain.mission.exception;

import hello.umc9th.global.apiPayload.code.BaseErrorCode;
import hello.umc9th.global.apiPayload.exception.GeneralException;

public class MissionException extends GeneralException {
    public MissionException(BaseErrorCode code) {
        super(code);
    }
}