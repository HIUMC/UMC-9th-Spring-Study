package UMC.week4.global.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum TestErrorCode implements BaseErrorCode{

    TEST_EXCEPTION(HttpStatus.BAD_REQUEST, "TEST400_1", "이거는 테스트");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
