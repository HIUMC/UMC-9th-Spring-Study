package hongikUMC.workbook.domain.review.converter;

import hongikUMC.workbook.domain.review.dto.res.ReviewResDTO;
import hongikUMC.workbook.domain.review.entity.Review;
import org.springframework.data.domain.Page;

public class ReviewConverter {

    /**
     * Review 엔티티 하나를 ReviewDTO로 변환하는 메소드
     */
    public static ReviewResDTO.ReviewDTO toReviewDTO(
            Review review
    ) {
        return ReviewResDTO.ReviewDTO.builder()
                .title(review.getTitle())
                .body(review.getBody())
                .rate(review.getRating())
                .build();
    }

    /**
     * Review 엔티티 리스트를 ReviewListDTO로 변환하는 메소드
     */
    public static ReviewResDTO.ReviewListDTO toReviewListDTO(
            Page<Review> reviewList
    ) {
        return ReviewResDTO.ReviewListDTO.builder()
                .reviewList(reviewList.getContent().stream()
                        .map(ReviewConverter::toReviewDTO)
                        .toList()
                )
                .listSize(reviewList.getSize())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .isFirst(reviewList.isFirst())
                .isLast(reviewList.isLast())
                .build();
    }
}
