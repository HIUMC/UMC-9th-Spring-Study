package hello.umc9th.domain.mission.controller;

import hello.umc9th.domain.mission.dto.MemberMissionResDTO;
import hello.umc9th.domain.mission.dto.MissionResDTO;
import hello.umc9th.domain.mission.service.MemberMissionQueryService;
import hello.umc9th.domain.mission.service.MissionQueryService;
import hello.umc9th.global.annotation.ValidPage;
import hello.umc9th.global.apiPayload.ApiResponse;
import hello.umc9th.global.apiPayload.code.GeneralSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
public class MissionQueryController {

    private final MissionQueryService missionQueryService;
    private final MemberMissionQueryService memberMissionQueryService;

    @Operation(
            summary = "특정 가게의 미션 목록 조회 API",
            description = "storeId에 해당하는 가게의 미션들을 페이지당 10개씩 조회합니다. page는 1 이상입니다."
    )
    @GetMapping("/stores/{storeId}/missions")
    public ApiResponse<MissionResDTO.MissionPreviewListDTO> getStoreMissions(
            @PathVariable Long storeId,
            @ValidPage @RequestParam Integer page
    ) {
        return ApiResponse.onSuccess(
                GeneralSuccessCode.OK,
                missionQueryService.getMissionsByStore(storeId, page)
        );
    }


    @Operation(
            summary = "내 진행중인 미션 목록 조회 API",
            description = "로그인 기능이 없어 임시로 1번 회원 기준으로, 진행중(IN_PROGRESS) 상태의 미션을 페이징 조회합니다."
    )
    @GetMapping("/my/missions")
    public ApiResponse<MemberMissionResDTO.MemberMissionPreviewListDTO> getMyInProgressMissions(
            @ValidPage @RequestParam Integer page
    ) {
        return ApiResponse.onSuccess(
                GeneralSuccessCode.OK,
                memberMissionQueryService.getMyInProgressMissions(page)
        );
    }
}