package hongikUMC.workbook.domain.member.exception.code;

import hongikUMC.workbook.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MemberErrorCode implements BaseErrorCode {
    NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER404", "해당 멤버는 존재하지 않습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
