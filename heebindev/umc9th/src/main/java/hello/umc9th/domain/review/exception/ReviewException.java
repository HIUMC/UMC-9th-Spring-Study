package hello.umc9th.domain.review.exception;

import hello.umc9th.global.apiPayload.code.BaseErrorCode;
import hello.umc9th.global.apiPayload.exception.GeneralException;

public class ReviewException extends GeneralException {
    public ReviewException(BaseErrorCode code) {
        super(code);
    }
}
