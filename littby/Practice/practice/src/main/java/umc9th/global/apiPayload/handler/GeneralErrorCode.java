package umc9th.global.apiPayload.handler;

import org.springframework.http.HttpStatus;
import umc9th.global.apiPayload.code.BaseErrorCode;

public enum GeneralErrorCode implements BaseErrorCode {

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,
            "COMMON500_1", "예기치 않은 서버 에러가 발생했습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;

    GeneralErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    @Override
    public HttpStatus getStatus() {
        return null;
    }

    @Override
    public String getCode() {
        return "";
    }

    @Override
    public String getMessage() {
        return "";
    }
}