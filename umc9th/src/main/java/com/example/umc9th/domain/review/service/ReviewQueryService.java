package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.review.dto.ReviewResponseDTO;

public interface ReviewQueryService {
    ReviewResponseDTO.ReviewPreviewListDTO getMyReviewList(Long memberId, Long storeId, Integer rating, Integer page);
}
