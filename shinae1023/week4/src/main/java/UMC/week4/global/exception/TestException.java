package UMC.week4.global.exception;

import UMC.week4.global.code.BaseErrorCode;

public class TestException extends GeneralException {
    public TestException(BaseErrorCode code) {
        super(code);
    }
}
