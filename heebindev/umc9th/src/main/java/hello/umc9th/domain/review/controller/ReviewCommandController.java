package hello.umc9th.domain.review.controller;

import hello.umc9th.domain.review.dto.ReviewReqDTO;
import hello.umc9th.domain.review.dto.ReviewResDTO;
import hello.umc9th.domain.review.exception.code.ReviewSuccessCode;
import hello.umc9th.domain.review.service.ReviewCommandService;
import hello.umc9th.domain.review.service.ReviewQueryServiceImpl;
import hello.umc9th.global.apiPayload.ApiResponse;
import hello.umc9th.global.apiPayload.code.GeneralSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReviewCommandController {

    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryServiceImpl reviewQueryService;

    @Operation(
            summary = "리뷰 작성!"
    )
    @PostMapping("/stores/{storeId}/reviews")
    public ApiResponse<ReviewResDTO.ReviewInfo> createReview(
            @PathVariable Long storeId, @RequestBody ReviewReqDTO.CreateReviewDTO dto
    ) {//@PathVariable인 storeId는 service에서 처리
        return ApiResponse.onSuccess(
                GeneralSuccessCode.OK,
                reviewCommandService.createReview(storeId, dto)
        );
    }

    //가게의 리뷰들 조회
    @Operation(
            summary = "특정 가게의 모든 리뷰를 조회, 페이징 처리",
            description = "가게번호와 페이지받기특정"
    )
    //특정 가게의 리뷰를 모두 조회
    @GetMapping("/stores/{storeId}/reviews")
    public ApiResponse<ReviewResDTO.ReviewPreviewListDTO> getStoreReviews(
            @PathVariable Long storeId, @RequestParam(defaultValue = "1") Integer page
    ){
        ReviewSuccessCode code = ReviewSuccessCode.FOUND;
        return ApiResponse.onSuccess(code, reviewQueryService.getReviewList(storeId, page));
    }
}
