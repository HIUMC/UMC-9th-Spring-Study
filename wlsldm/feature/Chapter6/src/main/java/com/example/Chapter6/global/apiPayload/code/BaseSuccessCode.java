package com.example.Chapter6.global.apiPayload.code;

import org.springframework.http.HttpStatus;


public interface BaseSuccessCode {
    HttpStatus getHttpStatus();
    String getCode();
    String getMessage();
}
