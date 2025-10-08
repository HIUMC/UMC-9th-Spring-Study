package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.review.dto.ReviewRequestDTO;
import com.example.umc9th.domain.review.entity.Review;
import org.springframework.transaction.annotation.Transactional;

public interface ReviewService {
    Review createReview(Long memberId, Long storeId, ReviewRequestDTO.CreateReviewDTO request);

    @Transactional
    Review  createReview(ReviewRequestDTO.CreateReviewDTO request);
}