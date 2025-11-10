package com.example.umc9th.global.exception;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * GeneralException은 우리 애플리케이션의 모든 비즈니스 로직 예외의 최상위 부모 클래스입니다.
 * 모든 커스텀 예외는 이 클래스를 상속받아 만들어집니다.
 * <p>
 * 이 클래스는 생성자를 통해 {@link BaseErrorCode}를 받아,
 * 예외 상황에 대한 구체적인 정보를 포함하게 됩니다.
 *
 * @author shinwook.kang
 */
@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    // BaseErrorCode를 필드로 가지며, 이 코드를 통해 에러의 상세 정보를 포함합니다.
    private final BaseErrorCode code;
}
