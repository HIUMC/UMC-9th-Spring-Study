package umc9th.domain.review.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc9th.domain.review.dto.ReviewRequestDTO;
import umc9th.domain.review.dto.ReviewResponseDTO;
import umc9th.domain.review.entity.Review;
import umc9th.global.annotation.CheckPage;
import umc9th.global.apiPayload.ApiResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/restaurants") // 공통 주소
public class ReviewController {


    @GetMapping("/users/reviews")
    @Operation(summary = "내가 작성한 리뷰 목록 조회 API", description = "내가 작성한 리뷰들의 목록을 조회. 페이징을 포함.")
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getMyReviews(
            @CheckPage @RequestParam(name = "page") Integer page
    ) {

        return ApiResponse.onSuccess(reviewService.getMyReviewList(page - 1));
    }

    private final ReviewService reviewService; // Service를 주입받아요
    private Object ReviewConverter;

    // POST /api/v1/restaurants/{restaurantId}/reviews
    @PostMapping("/{restaurantId}/reviews")
    public ApiResponse<ReviewResponseDTO.AddReviewResultDTO> addReview(
            @RequestBody ReviewRequestDTO.AddReviewDTO request,
            @PathVariable Long restaurantId) {

        Review review = reviewService.createReview(request, restaurantId);


        return ApiResponse.onSuccess(ReviewConverter.toAddReviewResultDTO(review));
    }
}