package com.example.umc9th.global.exception.handler;

import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import com.example.umc9th.global.apiPayload.code.status.ErrorStatus;
import com.example.umc9th.global.exception.GeneralException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * ExceptionAdvice는 애플리케이션 전반에 걸쳐 발생하는 예외를 중앙에서 처리하는 클래스입니다.
 * {@code @RestControllerAdvice} 어노테이션을 사용하여 모든 {@code @RestController}에서 발생하는 예외를 가로챕니다.
 *
 * @author shinwook.kang
 */
@Slf4j
@RestControllerAdvice(annotations = {RestController.class})
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    /**
     * 우리가 직접 정의한 비즈니스 로직상 예외인 GeneralException을 처리하는 핸들러입니다.
     *
     * @param e       발생한 GeneralException 객체
     * @param request 현재 웹 요청
     * @return ApiResponse 형식의 에러 응답
     */
    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<Object> handleGeneralException(GeneralException e, HttpServletRequest request) {
        // GeneralException에서 에러 코드를 추출하여 ApiResponse를 생성합니다.
        return handleExceptionInternal(e, e.getCode(), null, request);
    }

    /**
     * {@code @Valid} 어노테이션을 사용한 요청 DTO의 유효성 검사 실패 시 발생하는
     * {@code MethodArgumentNotValidException}을 처리합니다.
     *
     * @param e       발생한 MethodArgumentNotValidException 객체
     * @param headers HTTP 헤더
     * @param status  HTTP 상태 코드 (HttpStatusCode로 변경)
     * @param request 현재 웹 요청
     * @return ApiResponse 형식의 에러 응답
     */
    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException e, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Map<String, String> errors = new LinkedHashMap<>();

        // 유효성 검사 실패 필드와 메시지를 추출하여 Map에 저장합니다.
        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            String fieldName = fieldError.getField();
            String errorMessage = Optional.ofNullable(fieldError.getDefaultMessage()).orElse("");
            errors.merge(fieldName, errorMessage, (oldMsg, newMsg) -> oldMsg + ", " + newMsg);
        });

        // 상세 에러 정보를 포함하는 ApiResponse를 생성합니다.
        return handleExceptionInternalArgs(e, ErrorStatus._BAD_REQUEST, errors, headers, status, request);
    }

    //================================================================================
    // 내부 예외 처리 헬퍼 메소드
    //================================================================================

    private ResponseEntity<Object> handleExceptionInternalArgs(
            Exception e, ErrorStatus errorStatus, Map<String, String> errors,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) { // HttpStatusCode로 변경
        ApiResponse<Object> body = ApiResponse.of(errorStatus, errors);
        return super.handleExceptionInternal(
                e,
                body,
                headers,
                status,
                request
        );
    }

    private ResponseEntity<Object> handleExceptionInternal(Exception e, BaseErrorCode code, HttpHeaders headers, HttpServletRequest request) {
        // BaseErrorCode를 사용하여 ApiResponse를 생성합니다.
        ApiResponse<Object> body = ApiResponse.of(code, null);
        // HTTP 상태 코드를 BaseErrorCode에서 가져와 응답합니다.
        return new ResponseEntity<>(body, HttpStatus.valueOf(code.getReasonHttpStatus().getHttpStatus().value()));
    }
}
