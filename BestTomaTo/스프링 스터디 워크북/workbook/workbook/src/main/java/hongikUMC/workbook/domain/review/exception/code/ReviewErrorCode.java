package hongikUMC.workbook.domain.review.exception.code;

import hongikUMC.workbook.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ReviewErrorCode implements BaseErrorCode {

    BAD_REQUEST(HttpStatus.BAD_REQUEST, "REVIEW400", "리뷰 생성이 완료되지 않았습니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
