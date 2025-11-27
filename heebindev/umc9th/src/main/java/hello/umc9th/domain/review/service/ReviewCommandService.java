package hello.umc9th.domain.review.service;

import hello.umc9th.domain.review.dto.ReviewReqDTO;
import hello.umc9th.domain.review.dto.ReviewResDTO;
//생성 / 수정 / 삭제
public interface ReviewCommandService {
    ReviewResDTO.ReviewInfo createReview(Long storeId,ReviewReqDTO.CreateReviewDTO dto);
}
