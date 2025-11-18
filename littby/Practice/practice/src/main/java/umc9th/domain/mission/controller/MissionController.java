package umc9th.domain.mission.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc9th.domain.mission.dto.MissionRequestDTO;
import umc9th.domain.mission.entity.UserMission;
import umc9th.global.apiPayload.ApiResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/missions")
public class MissionController {

    private final MissionService missionService;


    @PostMapping("")
    public ApiResponse<MissionResponseDTO.ChallengeMissionResultDTO> challengeMission(
            @RequestBody MissionRequestDTO.ChallengeMissionDTO request) {


        UserMission userMission = missionService.createChallenge(request);

        return ApiResponse.onSuccess(MissionConverter.toChallengeMissionResultDTO(userMission));
    }
}