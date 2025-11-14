package hello.umc9th.domain.review.converter;

import hello.umc9th.domain.review.dto.ReviewResDTO;
import hello.umc9th.domain.review.entity.Review;

public class ReviewConverter {

    public static ReviewResDTO.ReviewInfo toReviewInfo(Review review) {
        return ReviewResDTO.ReviewInfo.builder()
                .id(review.getId())
                .reviewContent(review.getReviewContent())
                .reviewScore(review.getReviewScore().name())
                .storeName(review.getStore().getName())
                .location(review.getStore().getLocation().getStoreLocation().name())
                .memberName(review.getMember().getName())
                .build();
    }
}