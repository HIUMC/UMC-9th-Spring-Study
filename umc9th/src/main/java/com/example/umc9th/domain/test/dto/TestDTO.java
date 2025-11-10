package com.example.umc9th.domain.test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * TestDTO 클래스는 API 테스트에 사용될 다양한 DTO들을 그룹화하는 역할을 합니다.
 * 이 클래스 자체는 인스턴스화되지 않으며, 내부에 정적 중첩 클래스(static nested class) 형태로
 * 실제 사용될 DTO들을 정의합니다.
 *
 * @author shinwook.kang
 */
public class TestDTO {

    /**
     * TestRequestDTO는 클라이언트가 서버에게 POST 요청을 보낼 때의 데이터 구조를 정의합니다.
     */
    @Getter
    public static class TestRequestDTO {
        String name;
    }

    /**
     * TestResponseDTO는 서버가 클라이언트에게 응답할 때의 데이터 구조를 정의합니다.
     * public static class로 선언하여 TestDTO 클래스 내부에 정적으로 중첩시켜 관련 DTO들을 그룹화합니다.
     *
     * @Builder: 빌더 패턴을 적용하여 객체 생성을 용이하게 합니다.
     * @Getter: 모든 필드에 대한 getter 메소드를 자동으로 생성합니다.
     * @NoArgsConstructor: 기본 생성자를 생성합니다.
     * @AllArgsConstructor: 모든 필드를 포함하는 생성자를 생성합니다.
     */
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TestResponseDTO {
        // 응답에 포함될 테스트 문자열
        String testString;
        // 응답에 포함될 테스트 정수
        Integer testInteger;
    }
}
