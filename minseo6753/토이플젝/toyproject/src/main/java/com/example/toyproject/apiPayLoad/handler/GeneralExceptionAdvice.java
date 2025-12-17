package com.example.toyproject.apiPayLoad.handler;

import com.example.toyproject.apiPayLoad.ApiResponse;
import com.example.toyproject.apiPayLoad.code.error.BaseErrorCode;
import com.example.toyproject.apiPayLoad.code.error.GeneralErrorCode;
import com.example.toyproject.apiPayLoad.exception.GeneralException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionAdvice {

    @ExceptionHandler(GeneralException.class)
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
