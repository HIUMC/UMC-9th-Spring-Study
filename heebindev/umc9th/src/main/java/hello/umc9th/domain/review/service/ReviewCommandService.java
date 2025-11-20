package hello.umc9th.domain.review.service;

import hello.umc9th.domain.review.dto.ReviewReqDTO;
import hello.umc9th.domain.review.dto.ReviewResDTO;

public interface ReviewCommandService {
    ReviewResDTO.ReviewInfo createReview(ReviewReqDTO.CreateReviewDTO dto);
}
