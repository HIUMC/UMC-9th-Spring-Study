package com.example.umcworkbook.controller;

import com.example.umcworkbook.apiPayload.ApiResponse;
import com.example.umcworkbook.dto.res.ReviewResDto;
import com.example.umcworkbook.dto.res.ReviewResDto.PreviewListDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.Positive;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface ReviewControllerDocs {

    @Operation(
            summary = "가게의 리뷰 목록 조회 API",
            description = "특정 가게의 리뷰를 모두 조회합니다. 페이지네이션으로 제공합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400",description = "실패")
    })
    ApiResponse<ReviewResDto.PreviewListDto> getReviews(
            @RequestParam String restaurantName,
            @RequestParam Integer page
    );

    @Operation(
            summary = "내가 작성한 리뷰 목록 조회 API",
            description = "특정 사용자가 작성한 리뷰를 모두 조회합니다. 페이지네이션으로 제공합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400",description = "실패")
    })
    ApiResponse<PreviewListDto> getUserReviews(
            @PathVariable Long userId,
            @RequestParam(defaultValue = "1") @Positive Integer page
    );
}
