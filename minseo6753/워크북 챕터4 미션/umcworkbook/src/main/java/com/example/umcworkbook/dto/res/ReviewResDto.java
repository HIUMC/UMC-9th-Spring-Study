package com.example.umcworkbook.dto.res;

import lombok.Builder;

public class ReviewResDto {

    @Builder
    public record SearchDto(
            Long reviewId,
            String content,
            Float star
    ){}
}
