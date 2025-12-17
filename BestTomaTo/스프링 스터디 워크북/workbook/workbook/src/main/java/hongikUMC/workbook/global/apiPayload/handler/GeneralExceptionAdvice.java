package hongikUMC.workbook.global.apiPayload.handler;

import hongikUMC.workbook.global.apiPayload.ApiResponse;
import hongikUMC.workbook.global.apiPayload.code.BaseErrorCode;
import hongikUMC.workbook.global.apiPayload.code.GeneralErrorCode;
import hongikUMC.workbook.global.apiPayload.exception.GeneralException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionAdvice {

    // 애플리케이션에서 발생하는 커스텀 예외를 처리
    @ExceptionHandler(GeneralException.class)
    // 이 친구 덕분에 내가 설계한 예외를 잡을 수 있다.
    // 이 예외를 상속 받은 도메인에서 에러가 터지면, 부모 클래스인 GeneralException을 Code와 함께 호출한다.
    public ResponseEntity<ApiResponse<Void>> handleException(
            GeneralException ex
    ) {

        return ResponseEntity.status(ex.getCode().getStatus())
                .body(ApiResponse.onFailure(
                                ex.getCode(),
                                null
                        )
                );
    }

    // 그 외의 정의되지 않은 모든 예외 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleException(
            Exception ex
    ) {

        BaseErrorCode code = GeneralErrorCode.INTERNAL_SERVER_ERROR;
        return ResponseEntity.status(code.getStatus())
                .body(ApiResponse.onFailure(
                                code,
                                ex.getMessage()
                        )
                );
    }
}

