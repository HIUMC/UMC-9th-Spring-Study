package hongikUMC.workbook.global.apiPayload.exception;

import hongikUMC.workbook.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException { // RuntimeException을 상속 받는 전체 Exception 설계

    private final BaseErrorCode code;
}