package com.example.umc9th.web.controller;

import com.example.umc9th.domain.mission.converter.MissionConverter;
import com.example.umc9th.domain.mission.dto.MissionResponseDTO;
import com.example.umc9th.domain.mission.entity.mapping.UserMission;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.service.MissionService.MissionCommandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/{missionId}/challenge")
    @Operation(summary = "미션 도전하기 API", description = "특정 미션에 사용자가 도전하는 API입니다.")
    @Parameters({
            @Parameter(name = "missionId", description = "도전할 미션의 ID", required = true),
            @Parameter(name = "memberId", description = "도전하는 사용자의 ID", required = true) // 실제로는 SecurityContext에서 사용자 정보를 가져와야 함
    })
    public ApiResponse<MissionResponseDTO.ChallengeMissionDTO> challengeMission(
            @PathVariable(name = "missionId") Long missionId,
            @RequestParam(name = "memberId") Long memberId) {

        UserMission userMission = missionCommandService.challengeMission(missionId, memberId);
        return ApiResponse.onSuccess(MissionConverter.toChallengeMissionDTO(userMission));
    }
}