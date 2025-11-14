package hello.umc9th.global.apiPayload.code;

import org.springframework.http.HttpStatus;

public interface BaseErrorCode {
//구현해야하는 메서드

    //getter
    HttpStatus getHttpStatus();
    String getCode();
    String getMessage();
}
