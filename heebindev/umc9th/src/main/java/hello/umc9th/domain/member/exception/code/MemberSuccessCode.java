package hello.umc9th.domain.member.exception.code;

import hello.umc9th.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
public enum MemberSuccessCode implements BaseSuccessCode {
    Found(HttpStatus.OK, "Member200_1","성공적으로 사용자를 조회했습니다."),
    ;

    private final HttpStatus httpStatus; //@Getter가 getHttpStatus를 만들어주므로 인터페이스 만족
    private final String message; //@Getter가 getMessage를 만들어주므로 인터페이스 만족
    private final String code; //@Getter가 getCode를 만들어주므로 인터페이스 만족
}
