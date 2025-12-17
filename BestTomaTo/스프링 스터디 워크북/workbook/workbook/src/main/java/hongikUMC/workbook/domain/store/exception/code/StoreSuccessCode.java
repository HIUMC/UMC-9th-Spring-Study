package hongikUMC.workbook.domain.store.exception.code;

import hongikUMC.workbook.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum StoreSuccessCode implements BaseSuccessCode {

    OK(HttpStatus.OK, "STORE200", "상점 생성이 완료되었습니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
