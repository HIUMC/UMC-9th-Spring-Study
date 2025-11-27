package hello.umc9th.domain.review.exception.code;

import hello.umc9th.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ReviewSuccessCode implements BaseSuccessCode {
    //리뷰 등록 성공!
    CREATED(HttpStatus.CREATED, "Review202_1", "리뷰가 성공적으로 등록"),
    //리뷰 목록 조회 성공
    FOUND(HttpStatus.OK, "Review200_1", "리뷰 목록 조회에 성공했습니당."),
    ;


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}


