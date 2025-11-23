package com.example.umc9th.domain.review.dto;

public class ReviewReqDto {

    public record ReviewCreateDto(
            Long storeId,
            Float star,
            String content
    ){}
}
