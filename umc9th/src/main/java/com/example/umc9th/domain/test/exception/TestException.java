package com.example.umc9th.domain.test.exception;

import com.example.umc9th.domain.test.exception.code.TestErrorCode;
import com.example.umc9th.global.exception.GeneralException;

/**
 * TestException은 test 도메인에서 발생하는 예외 상황을 나타내는 클래스입니다.
 * GeneralException을 상속받아, test 도메인의 비즈니스 로직에서 발생하는
 * 예외를 보다 명확하게 표현하는 역할을 합니다.
 *
 * @author shinwook.kang
 */
public class TestException extends GeneralException {

    /**
     * 생성자에서 TestErrorCode를 받아 부모 클래스인 GeneralException으로 전달합니다.
     *
     * @param errorCode test 도메인에 특화된 에러 코드
     */
    public TestException(TestErrorCode errorCode) {
        super(errorCode);
    }
}
