package com.example.Chapter6.domain.review.controller;

import com.example.Chapter6.domain.review.dto.request.ReviewRequestDTO;
import com.example.Chapter6.domain.review.dto.response.ReviewResponseDTO;
import com.example.Chapter6.domain.review.exception.code.ReviewSuccessCode;
import com.example.Chapter6.domain.review.service.ReviewService;
import com.example.Chapter6.domain.review.service.command.ReviewCommandService;
import com.example.Chapter6.domain.review.service.query.ReviewQueryService;
import com.example.Chapter6.global.annotation.ValidPage;
import com.example.Chapter6.global.apiPayload.ApiResponse;
import com.example.Chapter6.global.apiPayload.code.GeneralSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryService reviewQueryService;

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

    @Operation(
            summary = "가게의 리뷰 목록 조회 API",
            description = "특정 가게의 모든 리뷰를 조회합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })
    @GetMapping("/reviews")
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getReviews(
            @RequestParam String storeName,
            @RequestParam Integer page
    ) {

        ReviewSuccessCode code = ReviewSuccessCode.FOUND;
        return ApiResponse.onSuccess(code, reviewQueryService.findReview(storeName, page));
    }

    @Operation(
            summary = "내가 작성한 리뷰 목록",
            description = "사용자가 작성한 리뷰를 조회합니다"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })
    @GetMapping("/my/reviews")
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getMyReviews(
            @RequestParam Long memberId,
            @RequestParam @Valid @ValidPage Integer page
    ) {

        ReviewSuccessCode code = ReviewSuccessCode.FOUND;
        return ApiResponse.onSuccess(code, reviewQueryService.findMyReview(memberId, page));
    }


}
