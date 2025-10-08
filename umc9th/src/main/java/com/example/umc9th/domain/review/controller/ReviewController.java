package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.ReviewRequestDTO;
import com.example.umc9th.domain.review.dto.ReviewResponseDTO;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ReviewResponseDTO.CreateReviewResultDTO createReview(
            @RequestParam Long memberId, // 실제로는 인증 정보에서 가져옵니다.
            @RequestParam Long storeId,
            @RequestBody ReviewRequestDTO.CreateReviewDTO request
    ) {
        Review review = reviewService.createReview(memberId, storeId, request);
        return ReviewConverter.toCreateReviewResultDTO(review);
    }
}