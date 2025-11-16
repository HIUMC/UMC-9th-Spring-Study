package com.example.umc9th.domain.review.dto;

import lombok.Getter;

@Getter
public class ReviewCreateRequestDto {

    private Long storeId;
    private Float star;
    private String content;
}
