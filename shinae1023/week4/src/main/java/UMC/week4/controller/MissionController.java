package UMC.week4.controller;

import UMC.week4.converter.MissionConverter;
import UMC.week4.domain.Mission;
import UMC.week4.domain.UserMission;
import UMC.week4.dto.MissionRequestDto;
import UMC.week4.dto.MissionResponseDto;
import UMC.week4.dto.UserMissionResponseDto;
import UMC.week4.global.apiPayload.ApiResponse;
import UMC.week4.service.MissionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionService missionService;

    /**
     * API 1: 가게의 미션을 도전중인 미션에 추가
     * [POST] /missions/{missionId}/members/{memberId}
     */
    @PostMapping("/{missionId}/members/{memberId}")
    public ApiResponse<UserMissionResponseDto.ChallengeMissionDTO> challengeMission(
            @PathVariable Long missionId,
            @PathVariable Long memberId
    ) {
        UserMission userMission = missionService.challengeMission(memberId, missionId);
        return ApiResponse.onSuccess("미션 시작 성공",MissionConverter.toChallengeMissionDTO(userMission));
    }

    /**
     * API 2: 가게에 미션 추가하기
     * [POST] /stores/{storeId}/missions
     * * @Valid : DTO의 유효성 검사를 수행합니다.
     */
    @PostMapping("/stores/{storeId}/missions")
    public ApiResponse<MissionResponseDto.CreateMissionDto> createMission(
            @PathVariable Long storeId,
            @RequestBody @Valid MissionRequestDto.CreateMissionDto request
    ) {
        Mission mission = missionService.createMission(storeId, request);
        return ApiResponse.onSuccess("미션 추가 성공",MissionConverter.toCreateMissionDTO(mission));
    }
}
