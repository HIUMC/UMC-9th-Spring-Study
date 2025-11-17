package com.example.Chapter6.domain.review.controller;

import com.example.Chapter6.domain.review.dto.request.ReviewRequestDTO;
import com.example.Chapter6.domain.review.dto.response.ReviewResponseDTO;
import com.example.Chapter6.domain.review.entity.Review;
import com.example.Chapter6.domain.review.exception.code.ReviewSucessCode;
import com.example.Chapter6.domain.review.service.ReviewService;
import com.example.Chapter6.domain.review.service.command.ReviewCommandService;
import com.example.Chapter6.domain.test.converter.TestConverter;
import com.example.Chapter6.domain.test.dto.response.TestResDTO;
import com.example.Chapter6.global.apiPayload.ApiResponse;
import com.example.Chapter6.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    private final ReviewCommandService reviewCommandService;

    @GetMapping("/review/search")
    public ApiResponse<List<ReviewResponseDTO>> search(
            @RequestParam String query,
            @RequestParam String type
    ) throws Exception {
        GeneralSuccessCode code = GeneralSuccessCode.OK;

        return ApiResponse.onSuccess(
                code,
                reviewService.searchReview(query, type)
        );

    }


    @GetMapping("/review/my")
    public ApiResponse<List<ReviewResponseDTO>> myReview(
            @RequestParam String query,
            @RequestParam String type
    ) throws Exception {
        GeneralSuccessCode code = GeneralSuccessCode.OK;

        return ApiResponse.onSuccess(
                code,
                reviewService.myReview(query, type)
        );
    }

    @PostMapping("/reviews")
    public ApiResponse<ReviewResponseDTO> review(
            @RequestBody ReviewRequestDTO.reviewDTO dto
            ) {
        return ApiResponse.onSuccess(ReviewSucessCode.FOUND,
                reviewCommandService.review(dto));
    }
}
