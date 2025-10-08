package com.example.umc9th.domain.review.dto;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

public class ReviewResponseDTO {
    @Builder
    @Getter
    public static class CreateReviewResultDTO {
        private Long reviewId;
        private LocalDateTime createdAt;
    }
}
