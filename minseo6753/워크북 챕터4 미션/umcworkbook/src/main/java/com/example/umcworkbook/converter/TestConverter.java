package com.example.umcworkbook.converter;

import com.example.umcworkbook.dto.res.TestResDto;

public class TestConverter {

    public static TestResDto.Testing toTestingDto(
            String testString
    ){
        return TestResDto.Testing.builder()
                .testString(testString)
                .build();
    }

    public static TestResDto.Exception toExceptionDto(
            String testString
    ){
        return TestResDto.Exception.builder()
                .testString(testString)
                .build();
    }
}
