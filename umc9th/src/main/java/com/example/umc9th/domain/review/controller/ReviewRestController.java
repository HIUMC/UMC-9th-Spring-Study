package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.ReviewRequestDTO;
import com.example.umc9th.domain.review.dto.ReviewResponseDTO;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.service.ReviewCommandService;
import com.example.umc9th.domain.review.service.ReviewQueryService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores/{storeId}/reviews")
public class ReviewRestController {

    private final ReviewQueryService reviewQueryService;
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.AddReviewResultDTO> addReview(@PathVariable Long storeId, @RequestBody ReviewRequestDTO.AddReviewDTO request) {
        Long memberId = 1L; // 임시로 1L로 설정, 로그인 구현 후 수정 필요
        Review review = reviewCommandService.addReview(memberId, storeId, request);
        return ApiResponse.onSuccess(ReviewConverter.toAddReviewResultDTO(review));
    }

    @GetMapping("/my")
    public ApiResponse<ReviewResponseDTO.ReviewPreviewListDTO> getMyReviews(
            @RequestParam(required = false) Long storeId,
            @RequestParam(required = false) Integer rating,
            @RequestParam(defaultValue = "1") Integer page) {

        // 임시로 memberId를 1L로 가정합니다. (로그인 기능 구현 후 수정 필요)
        Long memberId = 1L;

        ReviewResponseDTO.ReviewPreviewListDTO responseDTO = reviewQueryService.getMyReviewList(memberId, storeId, rating, page);
        return ApiResponse.onSuccess(responseDTO);
    }
}
