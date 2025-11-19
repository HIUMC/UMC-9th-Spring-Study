package com.example.umcworkbook.controller;

import com.example.umcworkbook.apiPayload.ApiResponse;
import com.example.umcworkbook.apiPayload.code.success.GeneralSuccessCode;
import com.example.umcworkbook.dto.req.ReviewReqDto;
import com.example.umcworkbook.dto.res.ReviewResDto;
import com.example.umcworkbook.service.command.ReviewCommandService;
import com.example.umcworkbook.service.query.ReviewQueryService;
import jakarta.validation.constraints.Positive;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewController implements ReviewControllerDocs{

    private final ReviewQueryService reviewQueryService;
    private final ReviewCommandService reviewCommandService;

    @GetMapping("/reviews/search")
    public ApiResponse<List<ReviewResDto.MyReviewDto>> searchReview(
            @RequestParam String query,
            @RequestParam String type
    ) {
        List<ReviewResDto.MyReviewDto> result = reviewQueryService.searchReview(query, type);
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(
                code,
                result
        );
    }

    @GetMapping("/users/{userId}/reviews")
    @Override
    public ApiResponse<ReviewResDto.PreviewListDto> getUserReviews(
            @PathVariable Long userId,
            @RequestParam(defaultValue = "1") @Positive Integer page
    ){
        return ApiResponse.onSuccess(
                GeneralSuccessCode.OK,
                reviewQueryService.findMemberReviews(userId, page-1)
        );
    }

    @GetMapping("/reviews")
    @Override
    public ApiResponse<ReviewResDto.PreviewListDto> getReviews(
            @RequestParam String restaurantName,
            @RequestParam(defaultValue = "1") Integer page
    ){
        return ApiResponse.onSuccess(
                GeneralSuccessCode.OK,
                reviewQueryService.findReview(restaurantName,page)
        );
    }

    @PostMapping("/users/{userId}/restaurants/{restaurantId}/reviews")
    public ApiResponse<ReviewResDto.MyReviewDto> createReview(
            @PathVariable Long userId,
            @PathVariable Long restaurantId,
            @RequestBody ReviewReqDto.CreateDto dto
    ){
        return ApiResponse.onSuccess(
                GeneralSuccessCode.CREATED,
                reviewCommandService.createReview(userId,restaurantId,dto)
        );
    }


}
