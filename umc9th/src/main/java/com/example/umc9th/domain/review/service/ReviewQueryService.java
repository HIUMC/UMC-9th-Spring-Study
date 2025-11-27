package com.example.umc9th.domain.review.service;
import com.example.umc9th.domain.review.dto.ReviewResponseDTO;

public interface ReviewQueryService {

    ReviewResponseDTO.ReviewListDTO getMyReviewList(Long memberId, Long storeId, Float rating, Integer page);

    // "내가 작성한 리뷰 목록 조회" 기능의 명세(설계도)
    ReviewResponseDTO.ReviewListDTO getReviewList(Long memberId, Integer page);

}
