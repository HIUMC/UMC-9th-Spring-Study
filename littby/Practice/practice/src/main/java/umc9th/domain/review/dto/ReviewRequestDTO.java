package umc9th.domain.review.dto;

import lombok.Builder;
import lombok.Getter;

public class ReviewRequestDTO {

    @Builder
    @Getter
    public static class AddReviewDTO {
        private String context;
        private Float star;
    }
}
