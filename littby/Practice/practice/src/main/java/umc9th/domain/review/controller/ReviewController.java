package umc9th.domain.review.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc9th.domain.review.dto.ReviewRequestDTO;
import umc9th.domain.review.entity.Review;
import umc9th.global.apiPayload.ApiResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/restaurants") // 공통 주소
public class ReviewController {

    private final ReviewService reviewService; // Service를 주입받아요
    private Object ReviewConverter;

    // POST /api/v1/restaurants/{restaurantId}/reviews
    @PostMapping("/{restaurantId}/reviews")
    public ApiResponse<ReviewResponseDTO.AddReviewResultDTO> addReview(
            @RequestBody ReviewRequestDTO.AddReviewDTO request,
            @PathVariable Long restaurantId) {

        // 실제 로직은 Service에 맡기고, DTO를 넘겨줘요.
        Review review = reviewService.createReview(request, restaurantId);

        // 성공 응답을 반환해요.
        return ApiResponse.onSuccess(ReviewConverter.toAddReviewResultDTO(review));
    }
}