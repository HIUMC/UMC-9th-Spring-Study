package com.example.umc9th.global.apiPayload.code.status;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import com.example.umc9th.global.apiPayload.code.ReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * ErrorStatus는 애플리케이션에서 발생하는 주요 에러 상황을 정의하는 열거형(enum)입니다.
 * 각 에러 코드는 HTTP 상태 코드, 고유한 에러 코드 문자열, 그리고 사용자에게 보여줄 메시지를 포함합니다.
 * 이 클래스는 BaseErrorCode 인터페이스를 구현하여, 모든 에러 코드가 일관된 형식을 갖도록 보장합니다.
 *
 * @author shinwook.kang
 */
@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    //================================================================================
    // 가장 일반적인 응답
    //================================================================================
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),


    //================================================================================
    // 멤버 관련 에러
    //================================================================================
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수 입니다."),

    //================================================================================
    // 예시,,,
    //================================================================================
    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "ARTICLE4001", "게시글이 없습니다."),

    // For test
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "이거는 테스트");


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    /**
     * getReason() 메소드는 에러 코드의 상세 정보를 ReasonDTO 객체로 변환합니다.
     * 이 객체는 isSuccess 필드가 항상 false로 설정됩니다.
     * 주로 내부 로깅이나 간단한 에러 정보 확인에 사용될 수 있습니다.
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
     * 이 객체는 API 응답의 바디에 포함될 최종 에러 정보를 나타내며,
     * ApiResponse.onFailure() 메소드에서 사용됩니다.
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
