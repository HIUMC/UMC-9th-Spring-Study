package umc9th.domain.mission.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc9th.domain.mission.dto.MissionRequestDTO;
import umc9th.domain.mission.dto.MissionResponseDTO;
import umc9th.domain.mission.entity.UserMission;
import umc9th.domain.mission.service.MissionService;
import umc9th.global.annotation.CheckPage;
import umc9th.global.apiPayload.ApiResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/missions")
public class MissionController {

    private final MissionService missionService;

    @GetMapping("/restaurants/{restaurantId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "특정 가게의 미션들을 조회")
    public ApiResponse<MissionResponseDTO.MissionListDTO> getRestaurantMissions(
            @PathVariable(name = "restaurantId") Long restaurantId,
            @CheckPage @RequestParam(name = "page") Integer page
    ) {
        return ApiResponse.onSuccess(missionService.getRestaurantMissions(restaurantId, page - 1));
    }

    @PostMapping("")
    public ApiResponse<MissionResponseDTO.ChallengeMissionResultDTO> challengeMission(
            @RequestBody MissionRequestDTO.ChallengeMissionDTO request) {


        UserMission userMission = missionService.createChallenge(request);

        return ApiResponse.onSuccess(MissionConverter.toChallengeMissionResultDTO(userMission));
    }
}