package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.ReviewReqDto;
import com.example.umc9th.domain.review.dto.ReviewResDto;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.exception.code.ReviewSuccessCode;
import com.example.umc9th.domain.review.service.ReviewQueryService;
import com.example.umc9th.domain.review.service.ReviewService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController implements ReviewControllerDocs {

    private final ReviewQueryService reviewQueryService;
    private final ReviewService reviewService;

    @PostMapping
    public ApiResponse<ReviewResDto.ReviewDetailDto> createReview(@RequestBody ReviewReqDto.ReviewCreateDto request) {
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
    public ApiResponse<List<ReviewResDto.ReviewDetailDto>> findMyReviews(
            @RequestParam String type,
            @RequestParam(required = false) String query,
            @RequestParam(required = false) Float star
    ) {
        List<ReviewResDto.ReviewDetailDto> reviews = reviewQueryService.findMyReviews(type, query, star);
        return ApiResponse.onSuccess(
                GeneralSuccessCode.OK,
                reviews
        );
    }

    // 가게의 리뷰 목록 조회
    @GetMapping
    public ApiResponse<ReviewResDto.ReviewPreViewListDto> getReviews(
            @RequestParam String storeName,
            @RequestParam(defaultValue = "1") Integer page){

        ReviewSuccessCode code = ReviewSuccessCode.FOUND;
        return ApiResponse.onSuccess(code, reviewQueryService.findReview(storeName, page));
    }

}
