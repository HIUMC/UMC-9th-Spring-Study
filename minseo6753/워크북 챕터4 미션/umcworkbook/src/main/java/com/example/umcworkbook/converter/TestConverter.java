package com.example.umcworkbook.converter;

import com.example.umcworkbook.dto.res.TestResDto;

public class TestConverter {

    public static TestResDto.Testing toTestingDto(
            String testing
    ){
        return TestResDto.Testing.builder()
                .testing(testing).build();
    }
}
