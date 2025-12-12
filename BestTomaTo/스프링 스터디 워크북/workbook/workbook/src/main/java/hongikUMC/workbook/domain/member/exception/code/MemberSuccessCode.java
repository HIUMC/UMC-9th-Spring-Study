package hongikUMC.workbook.domain.member.exception.code;

import hongikUMC.workbook.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MemberSuccessCode implements BaseSuccessCode {

    OK(HttpStatus.OK, "OK", "회원가입 완료"),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
