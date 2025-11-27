package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.common.annotation.CheckPage;
import com.example.umc9th.domain.mission.dto.MissionResponseDTO;
import com.example.umc9th.domain.mission.service.MissionQueryService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated // @RequestParam에 대한 유효성 검사를 활성화하기 위해 필요
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionQueryService missionQueryService;

    @GetMapping("/challenging")
    @Operation(summary = "내가 진행중인 미션 목록 조회 API", description = "특정 사용자가 '도전 중'인 미션 목록을 페이지네이션으로 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request (페이지 번호 오류)",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "memberId", description = "사용자 ID", required = true),
            @Parameter(name = "page", description = "페이지 번호 (1 이상)", required = true)
    })
    public ApiResponse<MissionResponseDTO.ChallengingMissionListDTO> getChallengingMissionList(
            @RequestParam(name = "memberId") Long memberId,
            @CheckPage @RequestParam(name = "page") Integer page) {

        MissionResponseDTO.ChallengingMissionListDTO result = missionQueryService.getChallengingMissionList(memberId, page);
        return ApiResponse.onSuccess(result);
    }
}