package hongikUMC.workbook.domain.test.exception;

import hongikUMC.workbook.global.apiPayload.code.BaseErrorCode;
import hongikUMC.workbook.global.apiPayload.exception.GeneralException;

public class TestException extends GeneralException {

    public TestException(BaseErrorCode code){
        super(code);
    }
}
