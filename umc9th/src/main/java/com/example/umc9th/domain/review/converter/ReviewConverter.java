package com.example.umc9th.domain.review.converter;

import com.example.umc9th.domain.review.dto.ReviewRequestDTO;
import com.example.umc9th.domain.review.dto.ReviewResponseDTO;
import com.example.umc9th.domain.review.entity.Review;

public class ReviewConverter {
    public static Review toReview(ReviewRequestDTO.CreateReviewDTO request) {
        return Review.builder()
                .content(request.getContent())
                .star(request.getRating())
                .build();
    }

    public static ReviewResponseDTO.CreateReviewResultDTO toCreateReviewResultDTO(Review review) {
        return ReviewResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }
}