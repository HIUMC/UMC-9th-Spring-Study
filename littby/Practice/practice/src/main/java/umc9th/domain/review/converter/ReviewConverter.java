package umc9th.domain.review.converter;

import umc9th.domain.review.entity.Review;
import umc9th.domain.review.dto.ReviewResponseDTO;

public class ReviewConverter {

    public static ReviewResponseDTO.AddReviewResultDTO toAddReviewResultDTO(Review review) {
        return ReviewResponseDTO.AddReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }
}
