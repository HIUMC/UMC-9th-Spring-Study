package com.example.umc9th.domain.test.converter;

import com.example.umc9th.domain.test.dto.TestDTO;

/**
 * TestConverter는 테스트용 API에서 사용될 데이터 변환을 담당합니다.
 * 이 클래스는 주로 정적(static) 메소드로 구성되어,
 * 특정 데이터를 DTO 객체로 변환하는 역할을 수행합니다.
 *
 * @author shinwook.kang
 */
public class TestConverter {

    /**
     * toTestResponseDTO 메소드는 응답 DTO를 생성하는 역할을 합니다.
     * 이 메소드는 컨트롤러로부터 받은 데이터를 사용하여 TestResponseDTO 객체를 빌더 패턴으로 생성합니다.
     *
     * @param testString 테스트 문자열
     * @param testInteger 테스트 정수
     * @return 생성된 TestResponseDTO 객체
     */
    public static TestDTO.TestResponseDTO toTestResponseDTO(String testString, Integer testInteger) {
        // TestResponseDTO의 빌더를 사용하여 객체를 생성하고 반환합니다.
        return TestDTO.TestResponseDTO.builder()
                .testString(testString)
                .testInteger(testInteger)
                .build();
    }
}
