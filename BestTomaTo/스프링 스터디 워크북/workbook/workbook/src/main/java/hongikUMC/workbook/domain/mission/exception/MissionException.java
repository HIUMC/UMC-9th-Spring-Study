package hongikUMC.workbook.domain.mission.exception;

import hongikUMC.workbook.global.apiPayload.code.BaseErrorCode;
import hongikUMC.workbook.global.apiPayload.exception.GeneralException;

public class MissionException extends GeneralException {
    public MissionException(BaseErrorCode code) {
        super(code);
    }
}
