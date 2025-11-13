package HongikSpring.demo.domain.test.exception;


import HongikSpring.demo.global.apiPayload.code.BaseErrorCode;
import HongikSpring.demo.global.apiPayload.exception.GeneralException;

public class TestException extends GeneralException {
    public TestException(BaseErrorCode code) {
        super(code);
    }
}
