package hongikUMC.workbook.domain.member.exception;

import hongikUMC.workbook.global.apiPayload.code.BaseErrorCode;
import hongikUMC.workbook.global.apiPayload.exception.GeneralException;

public class FoodException extends GeneralException {
    public FoodException(BaseErrorCode code) {
        super(code);
    }
}
