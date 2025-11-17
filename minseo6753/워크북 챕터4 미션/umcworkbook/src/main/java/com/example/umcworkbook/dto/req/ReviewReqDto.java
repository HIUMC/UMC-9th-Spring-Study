package com.example.umcworkbook.dto.req;

public class ReviewReqDto {

    public record CreateDto(
            Float star,
            String content
    ){}
}
