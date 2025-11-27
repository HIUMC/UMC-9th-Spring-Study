package hello.umc9th.domain.mission.controller;

import hello.umc9th.domain.mission.dto.MemberMissionReqDTO;
import hello.umc9th.domain.mission.dto.MemberMissionResDTO;
import hello.umc9th.domain.mission.service.MemberMissionCommandService;
import hello.umc9th.global.apiPayload.ApiResponse;
import hello.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberMissionCommandController {

    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/missions/{missionId}/challenge")
    public ApiResponse<MemberMissionResDTO.MemberMissionInfo> challengeMission(
            @PathVariable Long missionId
    ) {
        return ApiResponse.onSuccess(
                GeneralSuccessCode.OK,
                memberMissionCommandService.createMemberMission(missionId)
        );
    }
}