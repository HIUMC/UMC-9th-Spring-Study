package hello.umc9th.domain.review.exception.code;

import hello.umc9th.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ReviewErrorCode implements BaseErrorCode {
    REVIEW_NOT_FOUND(HttpStatus.NOT_FOUND, "REVIEW404_1", "해당 리뷰를 찾을 수 없습니다."),
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "REVIEW404_2", "해당 가게를 찾을 수 없습니다."),
    INVALID_SCORE(HttpStatus.BAD_REQUEST, "REVIEW400_1", "유효하지 않은 리뷰 점수입니다."),
    INVALID_FILTER(HttpStatus.BAD_REQUEST, "REVIEW400_2", "유효하지 않은 검색 필터입니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
