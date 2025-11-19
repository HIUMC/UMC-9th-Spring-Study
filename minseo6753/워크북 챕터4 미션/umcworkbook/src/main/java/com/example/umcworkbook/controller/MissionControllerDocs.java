package com.example.umcworkbook.controller;

import com.example.umcworkbook.apiPayload.ApiResponse;
import com.example.umcworkbook.dto.res.MissionResDto;
import com.example.umcworkbook.dto.res.ReviewResDto.PreviewListDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.Positive;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface MissionControllerDocs {

    @Operation(
            summary = "특정 가게의 미션 목록 API",
            description = "특정 가게의 미션을 모두 조회합니다. 페이지네이션으로 제공합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400",description = "실패")
    })
    ApiResponse<MissionResDto.PreviewListDto> getRestaurantMissions(
            @PathVariable Long restaurantId,
            @RequestParam(defaultValue = "1") @Positive Integer page
    );
}
