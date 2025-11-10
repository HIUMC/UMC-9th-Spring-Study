package com.example.umc9th.global.apiPayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.example.umc9th.global.apiPayload.code.BaseCode;
import com.example.umc9th.global.apiPayload.code.status.SuccessStatus;
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

    // 성공한 경우 응답 생성
    public static <T> ApiResponse<T> onSuccess(T result) {
        return new ApiResponse<>(true, SuccessStatus._OK.getCode(), SuccessStatus._OK.getMessage(), result);
    }

    // BaseCode를 사용하여 응답 생성 (성공/실패 모두 처리 가능하도록 수정)
    /**
     * BaseCode를 사용하여 API 응답을 생성합니다.
     * 이 메소드는 성공 및 실패 응답 모두를 처리할 수 있도록 isSuccess 필드를 BaseCode에서 가져옵니다.
     *
     * @param code BaseCode를 구현하는 코드 (예: SuccessStatus._OK, ErrorStatus.MEMBER_NOT_FOUND)
     * @param result 응답 데이터
     * @param <T> 응답 데이터의 타입
     * @return ApiResponse 객체
     */
    public static <T> ApiResponse<T> of(BaseCode code, T result) {
        return new ApiResponse<>(
                code.getReasonHttpStatus().isSuccess(), // isSuccess() 메소드로 수정
                code.getReasonHttpStatus().getCode(),
                code.getReasonHttpStatus().getMessage(),
                result
        );
    }

    // 실패한 경우 응답 생성
    public static <T> ApiResponse<T> onFailure(String code, String message, T data) {
        return new ApiResponse<>(false, code, message, data);
    }
}
