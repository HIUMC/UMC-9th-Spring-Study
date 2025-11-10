package com.example.Chapter6.domain.test.converter;

import com.example.Chapter6.domain.test.dto.response.TestResDTO;

public class TestConverter {

    //객체를 DTO로 변환
    public static TestResDTO.Testing toTestingDTO(String testing){
        return TestResDTO.Testing.builder()
                .testing(testing)
                .build();
    }

    // 객체 -> DTO
    public static TestResDTO.Exception toExceptionDTO(
            String testing
    ){
        return TestResDTO.Exception.builder()
                .testString(testing)
                .build();
    }
}
