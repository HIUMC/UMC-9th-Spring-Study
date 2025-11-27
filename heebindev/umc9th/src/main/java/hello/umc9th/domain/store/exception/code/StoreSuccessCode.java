package hello.umc9th.domain.store.exception.code;

import hello.umc9th.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum StoreSuccessCode implements BaseSuccessCode {

    FOUND(HttpStatus.OK, "store200","가게 조회에 성공했습니다/"),
    CREADTED(HttpStatus.CREATED, "store_201", "가게 생성에 성공했습니다")
    ,
    ;


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
