package com.example.umcworkbook.dto.res;

import lombok.Builder;
import lombok.Getter;

public class TestResDto {

    @Builder
    @Getter
    public static class Testing{
        private String testing;
    }
}
