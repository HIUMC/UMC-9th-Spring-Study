package umc9th.domain.test.exception;

import umc9th.global.apiPayload.code.BaseErrorCode;
import umc9th.global.apiPayload.exception.GeneralException;

public class TestExecption extends GeneralException {
    public TestExecption(BaseErrorCode code) {
        super(code);
    }
}
