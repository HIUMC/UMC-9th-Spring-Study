package com.example.umc9th.web.controller;

import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.store.converter.StoreConverter;
import com.example.umc9th.domain.store.dto.StoreResponseDTO;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.service.StoreService.StoreQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreQueryService storeQueryService;

    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "가게의 리뷰 목록 조회 API", description = "특정 가게의 리뷰 목록을 조회하는 API이며, 페이징을 포함합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "STORE2001", description = "가게 리뷰 목록 조회를 성공했습니다."),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "STORE4001", description = "해당하는 가게가 없습니다.", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다."),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다.")
    })
    public ApiResponse<StoreResponseDTO.ReviewPreviewListDTO> getReviewList(@PathVariable(name = "storeId") Long storeId, @RequestParam(name = "page") Integer page) {
        // 1. 서비스 계층에서 리뷰 목록 조회
        Page<Review> reviewPage = storeQueryService.getReviewList(storeId, page);

        // 2. Converter를 사용하여 응답 DTO로 변환
        StoreResponseDTO.ReviewPreviewListDTO reviewPreviewListDTO = StoreConverter.toReviewPreviewListDTO(reviewPage);

        // 3. 성공 응답 반환
        return ApiResponse.onSuccess(reviewPreviewListDTO);
    }
}
