package hello.umc9th.domain.member.exception.code;

import hello.umc9th.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MemberErrorCode implements BaseErrorCode {

    NOT_FOUND(HttpStatus.NOT_FOUND, "member404","해당 사용자를 찾지 못했습니다."),
    INVALID(HttpStatus.UNAUTHORIZED,"member401","이메일 또는 비밀번호가 바르지 않습니다." );

    private final HttpStatus httpStatus; //@Getter가 getHttpStatus를 만들어주므로 인터페이스 만족
    private final String message; //@Getter가 getMessage를 만들어주므로 인터페이스 만족
    private final String code; //@Getter가 getCode를 만들어주므로 인터페이스 만족
}
