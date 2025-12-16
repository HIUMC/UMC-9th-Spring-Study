package com.example.umc9th.global.apiPayload.code.status;

import com.example.umc9th.global.apiPayload.code.BaseCode;
import com.example.umc9th.global.apiPayload.code.ReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MemberSuccessCode implements BaseCode {

    // 멤버 관련 응답
    MEMBER_FOUND(HttpStatus.OK, "MEMBER_2001", "사용자 조회 성공"),
    MEMBER_TERMS_AGREED(HttpStatus.OK, "MEMBER_2002", "사용자 약관 동의 성공"),
    MEMBER_JOIN_SUCCESS(HttpStatus.CREATED, "MEMBER_2011", "사용자 회원가입 성공"),
    MEMBER_LOGIN_SUCCESS(HttpStatus.OK, "MEMBER_2021", "사용자 로그인 성공");


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build();
    }
}