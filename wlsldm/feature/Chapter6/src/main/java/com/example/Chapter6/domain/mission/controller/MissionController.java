package com.example.Chapter6.domain.mission.controller;

import com.example.Chapter6.domain.mission.dto.response.MissionResDTO;
import com.example.Chapter6.domain.mission.exception.code.MissionSuccessCode;
import com.example.Chapter6.domain.mission.service.query.MissionQueryService;
import com.example.Chapter6.global.annotation.ValidPage;
import com.example.Chapter6.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MissionController {

    private final MissionQueryService missionQueryService;

    @Operation(
            summary = "가게의 미션 목록 조회 API",
            description = "특정 가게의 모든 미션를 조회합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })
    @GetMapping("/missions")
    public ApiResponse<MissionResDTO.MissionPreViewListDTO> getMissions(
            @RequestParam String storeName,
            @RequestParam @Valid @ValidPage Integer page
    ) {
        MissionSuccessCode code = MissionSuccessCode.FOUND;

        return ApiResponse.onSuccess(code, missionQueryService.findMission(storeName, page));
    }

    @Operation(
            summary = "사용자가 진행 중인 미션 목록",
            description = "특정 사용자가 진행 중인 미션들을 불러옵니다"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })
    @GetMapping("/my/missions")
    public ApiResponse<MissionResDTO.MissionPreViewListDTO> getMyMissions(
            @RequestParam Long userId,
            @RequestParam @Valid @ValidPage Integer page
    ) {
        MissionSuccessCode code = MissionSuccessCode.FOUND;

        return ApiResponse.onSuccess(code, missionQueryService.findMyMission(userId, page));
    }
}
