package umc9th.global.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc9th.global.apiPayload.code.BaseErrorCode;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private final BaseErrorCode code;
}
