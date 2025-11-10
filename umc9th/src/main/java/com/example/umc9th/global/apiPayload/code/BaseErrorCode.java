package com.example.umc9th.global.apiPayload.code;

/**
 * 모든 에러 코드가 구현할 최상위 인터페이스입니다.
 * <p>
 * 이 인터페이스는 BaseCode를 상속받아, 모든 에러 코드가 getReason()과 getReasonHttpStatus() 메소드를
 * 구현하도록 강제합니다. 이를 통해 성공 코드와 에러 코드의 응답 구조를 통일성 있게 관리할 수 있습니다.
 * 추가적인 메소드가 필요한 경우 여기에 정의하여 모든 에러 코드에 공통적으로 적용할 수 있습니다.
 *
 * @author shinwook.kang
 */
public interface BaseErrorCode extends BaseCode {

    // BaseCode에 정의된 getReason()과 getReasonHttpStatus()를 그대로 사용합니다.

}
