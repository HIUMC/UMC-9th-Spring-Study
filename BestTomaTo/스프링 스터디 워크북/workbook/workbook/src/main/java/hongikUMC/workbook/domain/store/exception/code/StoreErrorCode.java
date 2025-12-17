package hongikUMC.workbook.domain.store.exception.code;

import hongikUMC.workbook.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum StoreErrorCode implements BaseErrorCode {

    BAD_REQUEST(HttpStatus.BAD_REQUEST, "STORE400", "상점을 생성할 수 없습니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
