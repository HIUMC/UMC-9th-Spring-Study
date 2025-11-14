package hello.umc9th.global.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum GeneralSuccessCode implements BaseSuccessCode {
    OK(HttpStatus.OK,
            "SUCCESS200",
            "요청이 성공적으로 처리되었습니다."),
    CREATED(HttpStatus.CREATED,
            "SUCCESS201",
            "리소스가 성공적으로 생성되었습니다."),
    NO_CONTENT(HttpStatus.NO_CONTENT,
            "SUCCESS204",
            "성공했지만 반환할 데이터가 없습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
