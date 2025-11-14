package hello.umc9th.domain.test.exception;

import hello.umc9th.global.apiPayload.code.BaseErrorCode;
import hello.umc9th.global.apiPayload.exception.GeneralException;

public class TestException extends GeneralException {
    public TestException(BaseErrorCode code) {
        super(code);
    }
}
