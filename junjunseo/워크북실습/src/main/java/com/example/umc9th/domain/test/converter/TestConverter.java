package com.example.umc9th.domain.test.converter;

import com.example.umc9th.domain.test.dto.res.TestResDto;

public class TestConverter {

    // 객체 -> DTO
    public static TestResDto.Testing toTestingDTO(
            String testing
    ) {
        return TestResDto.Testing.builder()
                .testString(testing)
                .build();
    }

    // 객체 -> DTO
    public static TestResDto.Exception toExceptionDTO(
            String testing
    ){
        return TestResDto.Exception.builder()
                .testString(testing)
                .build();
    }
}