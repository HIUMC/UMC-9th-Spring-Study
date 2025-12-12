package hongikUMC.workbook.domain.review.dto.res;

import lombok.Builder;

import java.time.LocalDateTime;

public class ReviewResDTO {

    @Builder
    public record saveReviewDTO(
            Long review_id,
            LocalDateTime created_at
    ){}
}
