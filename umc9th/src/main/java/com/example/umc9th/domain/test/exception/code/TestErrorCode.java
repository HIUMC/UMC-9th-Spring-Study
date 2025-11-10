package com.example.umc9th.domain.test.exception.code;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import com.example.umc9th.global.apiPayload.code.ReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * TestErrorCode는 test 도메인에서 발생하는 예외 상황에 대한 에러 코드를 정의하는 열거형입니다.
 * 이 클래스는 BaseErrorCode 인터페이스를 구현하여, 모든 에러 코드가 일관된 형식을 갖도록 합니다.
 *
 * @author shinwook.kang
 */
@Getter
@AllArgsConstructor
public enum TestErrorCode implements BaseErrorCode {

    // 'flag'가 1일 때 발생시킬 에러를 정의합니다.
    // HTTP 상태는 BAD_REQUEST(400), 고유 코드는 "TEST4001"로 지정합니다.
    FLAG_ONE_ERROR(HttpStatus.BAD_REQUEST, "TEST4001", "Flag가 1일 때 발생하는 테스트 예외입니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    /**
     * getReason() 메소드는 에러 코드의 상세 정보를 ReasonDTO 객체로 변환합니다.
     * isSuccess 필드는 항상 false로 설정됩니다.
     *
     * @return ReasonDTO (isSuccess=false, code, message)
     */
    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    /**
     * getReasonHttpStatus() 메소드는 에러 코드의 상세 정보와 HTTP 상태 코드를 포함하는 ReasonDTO 객체를 생성합니다.
     * 이 객체는 최종 API 응답에 사용됩니다.
     *
     * @return ReasonDTO (isSuccess=false, code, message, httpStatus)
     */
    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}
