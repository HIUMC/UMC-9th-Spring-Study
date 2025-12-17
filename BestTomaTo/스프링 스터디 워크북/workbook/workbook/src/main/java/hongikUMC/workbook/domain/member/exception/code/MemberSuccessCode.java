package hongikUMC.workbook.domain.member.exception.code;

import hongikUMC.workbook.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MemberSuccessCode implements BaseSuccessCode {

    OK_SIGNUP(HttpStatus.OK, "MEMBER200", "회원가입 완료"),
    OK_LOGIN(HttpStatus.OK, "MEMBER200", "로그인이 승인되었습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
