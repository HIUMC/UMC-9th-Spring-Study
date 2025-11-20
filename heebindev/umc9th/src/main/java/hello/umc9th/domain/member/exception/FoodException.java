package hello.umc9th.domain.member.exception;

import hello.umc9th.global.apiPayload.code.BaseErrorCode;
import hello.umc9th.global.apiPayload.exception.GeneralException;

public class FoodException extends GeneralException {
    public FoodException(BaseErrorCode code) {
        super(code);
    }
}
