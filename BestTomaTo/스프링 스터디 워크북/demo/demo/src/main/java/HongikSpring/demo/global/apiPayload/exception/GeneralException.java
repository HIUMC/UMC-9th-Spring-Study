package HongikSpring.demo.global.apiPayload.exception;

import HongikSpring.demo.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException{
    private final BaseErrorCode code;
}
