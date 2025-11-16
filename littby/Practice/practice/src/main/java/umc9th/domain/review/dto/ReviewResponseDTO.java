package umc9th.domain.review.dto;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

public class ReviewResponseDTO {

    @Builder
    @Getter
    public static class AddReviewResultDTO {
        Long reviewId; // 생성된 리뷰의 ID
        LocalDateTime createdAt; // 생성된 시간
    }
}
