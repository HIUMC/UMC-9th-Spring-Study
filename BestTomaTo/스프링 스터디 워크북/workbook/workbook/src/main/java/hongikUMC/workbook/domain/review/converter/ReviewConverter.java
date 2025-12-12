package hongikUMC.workbook.domain.review.converter;

import hongikUMC.workbook.domain.review.dto.req.ReviewReqDTO;
import hongikUMC.workbook.domain.review.dto.res.ReviewResDTO;
import hongikUMC.workbook.domain.review.entity.Review;

public class ReviewConverter {

    // 객체 -> DTO
    public static ReviewResDTO.saveReviewDTO toReviewDTO(
            Review review
    ){
        return ReviewResDTO.saveReviewDTO.builder()
                .review_id(review.getReview_id())
                .created_at(review.getCreated_at())
                .build();
    }

    // DTO -> 객체
    public static Review toReview(
            ReviewReqDTO.saveReviewDTO dto
    ){
        return Review.builder()
                .title(dto.title())
                .body(dto.body())
                .build();
    }

}
