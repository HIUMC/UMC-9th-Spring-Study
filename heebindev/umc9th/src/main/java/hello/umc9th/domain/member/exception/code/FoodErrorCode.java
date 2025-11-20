package hello.umc9th.domain.member.exception.code;

import hello.umc9th.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum FoodErrorCode implements BaseErrorCode {

    NOT_FOUND(HttpStatus.NOT_FOUND, "Food404_1", "해당 음식 카테고리를 찾을 수 없습니다."),
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}

