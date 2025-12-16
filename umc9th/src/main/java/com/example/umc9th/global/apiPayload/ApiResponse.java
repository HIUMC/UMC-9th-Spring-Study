package com.example.umc9th.global.apiPayload;

import com.example.umc9th.global.apiPayload.code.BaseCode;
import com.example.umc9th.global.apiPayload.code.status.SuccessStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class ApiResponse<T> {

    @JsonProperty("isSuccess")
    private final Boolean isSuccess;
    private final String code;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;

    // 범용적인 of 메서드 (가장 중요)
    public static <T> ApiResponse<T> of(BaseCode code, T result) {
        return new ApiResponse<>(
                code.getReasonHttpStatus().isSuccess(),
                code.getReasonHttpStatus().getCode(),
                code.getReasonHttpStatus().getMessage(),
                result
        );
    }

    // 성공 응답 (결과 데이터만 있을 때)
    public static <T> ApiResponse<T> onSuccess(T result) {
        return of(SuccessStatus._OK, result);
    }

    // 실패 응답 (결과 데이터가 없을 때)
    public static <T> ApiResponse<T> onFailure(BaseCode errorCode, T result) {
        return of(errorCode, result);
    }
}