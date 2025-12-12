package hongikUMC.workbook.domain.review.dto.req;

import hongikUMC.workbook.domain.review.enums.Rating;

public class ReviewReqDTO {

    public record saveReviewDTO(
            Long store_id,
            Long member_id,
            String title,
            String body,
            Long rate
    ){}
}
