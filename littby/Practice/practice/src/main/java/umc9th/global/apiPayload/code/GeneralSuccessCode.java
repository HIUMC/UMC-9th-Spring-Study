package umc9th.global.apiPayload.code;

import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GeneralSuccessCode implements BaseSuccessCode {

    // 200 : 요청 성공
    OK(HttpStatus.OK,
            "COMMON200",
            "요청이 성공적으로 처리되었습니다."),

    // 201 : 리소스 생성 성공
    CREATED(HttpStatus.CREATED,
            "COMMON201",
            "리소스가 성공적으로 생성되었습니다."),

    // 204 : 요청 성공했지만, 반환할 콘텐츠 없음
    NO_CONTENT(HttpStatus.NO_CONTENT,
            "COMMON204_1",
            "요청은 성공했으나, 반환할 내용이 없습니다.");

    // GeneralErrorCode와 동일한 필드
    private final HttpStatus status;
    private final String code;
    private final String message;
}