package hongikUMC.workbook.domain.review.exception;

import hongikUMC.workbook.global.apiPayload.code.BaseErrorCode;
import hongikUMC.workbook.global.apiPayload.exception.GeneralException;

public class ReviewException extends GeneralException {
    public ReviewException(BaseErrorCode code) {
        super(code);
    }
}
