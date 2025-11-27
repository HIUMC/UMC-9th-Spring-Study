package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.common.annotation.CheckPage;
import com.example.umc9th.domain.review.dto.ReviewResponseDTO;
import com.example.umc9th.domain.review.service.ReviewQueryService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewQueryService reviewQueryService;

    @GetMapping("/members/{memberId}")
    @Operation(summary = "내가 작성한 리뷰 목록 조회 API", description = "특정 사용자가 작성한 리뷰 목록을 페이징 처리하여 조회합니다.")
    @Parameters({
            @Parameter(name = "memberId", description = "사용자의 아이디", required = true),
            @Parameter(name = "page", description = "페이지 번호, 1 이상의 숫자를 입력해주세요.", required = true)
    })
    // 반환 타입을 ReviewListDTO로 정확하게 수정합니다.
    public ApiResponse<ReviewResponseDTO.ReviewListDTO> getReviewList(
            @PathVariable(name = "memberId") Long memberId,
            @CheckPage @RequestParam(name = "page") Integer page) {

        ReviewResponseDTO.ReviewListDTO reviewListDTO = reviewQueryService.getReviewList(memberId, page);
        return ApiResponse.onSuccess(reviewListDTO);
    }

    // 참고: 만약 getMyReviewList를 위한 컨트롤러 메서드가 있다면,
    // 그 메서드의 반환 타입도 아래와 같이 수정해야 합니다.
    /*
    @GetMapping("/members/{memberId}/stores/{storeId}")
    @Operation(summary = "특정 사용자가 특정 가게에 쓴 리뷰 필터링 API", description = "평점 등으로 리뷰를 필터링합니다.")
    // 반환 타입을 ReviewListDTO로 정확하게 수정합니다.
    public ApiResponse<ReviewResponseDTO.ReviewListDTO> getMyReviewList(
            @PathVariable Long memberId,
            @PathVariable Long storeId,
            @RequestParam Float rating,
            @CheckPage @RequestParam Integer page) {

        ReviewResponseDTO.ReviewListDTO reviewListDTO = reviewQueryService.getMyReviewList(memberId, storeId, rating, page);
        return ApiResponse.onSuccess(reviewListDTO);
    }
    */
}