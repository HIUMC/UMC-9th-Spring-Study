package com.example.umc9th.global.annotation;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PageParam {
    /**
     * 쿼리 스트링에서 읽을 파라미터 이름
     * 기본 값은 "page"
     */
    String value() default "page";
}
