package com.example.umc9th.domain.review.dto;

import lombok.Getter;

public class ReviewRequestDTO {
    @Getter
    public static class CreateReviewDTO {
        private String content;
        private Float rating;
    }
}