package com.example.umc9th.web.controller;

import com.example.umc9th.domain.common.annotation.CheckPage;
import com.example.umc9th.domain.review.dto.ReviewResponseDTO;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.service.StoreService.StoreQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreQueryService storeQueryService;

    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API", description = "특정 가게의 리뷰들을 페이징 처리하여 조회합니다.")
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디", required = true),
            @Parameter(name = "page", description = "페이지 번호, 1 이상의 숫자를 입력해주세요.", required = true)
    })
    public ApiResponse<ReviewResponseDTO.ReviewListDTO> getReviewList(
            @PathVariable(name = "storeId") Long storeId,
            @CheckPage @RequestParam(name = "page") Integer page) {

        ReviewResponseDTO.ReviewListDTO reviewListDTO = storeQueryService.getReviewList(storeId, page);
        return ApiResponse.onSuccess(reviewListDTO);
    }
}