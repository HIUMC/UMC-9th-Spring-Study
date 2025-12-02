package com.example.Chapter6.domain.review.service.query;

import com.example.Chapter6.domain.review.dto.response.ReviewResponseDTO;

public interface ReviewQueryService {

    ReviewResponseDTO.ReviewPreViewListDTO findReview(
            String storeName,
            Integer page
    );

    ReviewResponseDTO.ReviewPreViewListDTO findMyReview(
            Long memberId,
            Integer page
    );
}
