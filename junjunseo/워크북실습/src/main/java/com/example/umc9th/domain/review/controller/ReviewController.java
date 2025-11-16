package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.ReviewCreateRequestDto;
import com.example.umc9th.domain.review.dto.ReviewResponseDto;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.service.ReviewQueryService;
import com.example.umc9th.domain.review.service.ReviewService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewQueryService reviewQueryService;
    private final ReviewService reviewService;

    @PostMapping
    public ApiResponse<ReviewResponseDto> createReview(@RequestBody ReviewCreateRequestDto request) {
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, reviewService.createReview(request));
    }
/*
    @GetMapping("/search")
    public List<Review> searchReview(
            @RequestParam String query,
            @RequestParam String type
    ) {

        //서비스에게 요청
        List<Review> result = reviewQueryService.searchReview(query, type);
        return result;
    }
 */

    @GetMapping("/my")
    public ApiResponse<List<ReviewResponseDto>> findMyReviews(
            @RequestParam String type,
            @RequestParam(required = false) String query,
            @RequestParam(required = false) Float star
    ) {
        List<ReviewResponseDto> reviews = reviewQueryService.findMyReviews(type, query, star);
        return ApiResponse.onSuccess(
                GeneralSuccessCode.OK,
                reviews
        );
    }
}
