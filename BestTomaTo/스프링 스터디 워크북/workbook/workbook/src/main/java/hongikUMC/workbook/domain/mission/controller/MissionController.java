package hongikUMC.workbook.domain.mission.controller;

import hongikUMC.workbook.domain.mission.dto.res.MissionResDTO;
import hongikUMC.workbook.domain.mission.service.MissionQueryService;
import hongikUMC.workbook.domain.store.service.StoreQueryService;
import hongikUMC.workbook.domain.review.dto.res.ReviewResDTO;
import hongikUMC.workbook.global.apiPayload.ApiResponse;
import hongikUMC.workbook.global.apiPayload.code.GeneralSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MissionController {

    private final MissionQueryService missionQueryService;

    @GetMapping("/{storeId}/mission")
    @Operation(summary = "특정 가게 미션 조회", description = "특정 가게 미션 조회")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "미션이 존재하지 않습니다")

    })
    public ApiResponse<MissionResDTO.MissionListDTO> getStoreMissionList(
            @RequestParam Long storeId,
            @RequestParam Integer page
    ) {
        MissionResDTO.MissionListDTO myMissionList = missionQueryService.getMissionByStore(storeId, page);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, myMissionList);
    }

    @GetMapping("/{memberId}/mission")
    @Operation(summary = "특정 가게 미션 조회", description = "특정 가게 미션 조회")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "미션이 존재하지 않습니다")

    })
    public ApiResponse<MissionResDTO.MemberMissionListDTO> getMyMissionList(
            @RequestParam Long memberId,
            @RequestParam Integer page
    ) {
        MissionResDTO.MemberMissionListDTO myMissionList = missionQueryService.getMissionByMember(memberId, page);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, myMissionList);
    }
}
