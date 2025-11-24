package UMC.week4.controller;

import UMC.week4.converter.MissionConverter;
import UMC.week4.domain.Mission;
import UMC.week4.domain.UserMission;
import UMC.week4.dto.MissionRequestDto;
import UMC.week4.dto.MissionResponseDto;
import UMC.week4.dto.UserMissionResponseDto;
import UMC.week4.global.apiPayload.ApiResponse;
import UMC.week4.global.validation.CheckPage;
import UMC.week4.service.MissionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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

    @GetMapping("/{storeId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "특정 가게의 미션들을 조회하는 API이며, 페이징을 포함합니다. query String으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON400", description = "서버 에러, 관리자에게 문의 바랍니다.")
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 1번이 1 페이지 입니다.")
    })
    public ApiResponse<MissionResponseDto.MissionPreviewListDto> getMissions(
            @PathVariable(name = "storeId") Long storeId,
            @CheckPage @RequestParam(name = "page") Integer page
    ) {
        Page<Mission> missionList = missionService.getMissionList(storeId, page);
        return ApiResponse.onSuccess("미션 목록 조회 성공",MissionConverter.toMissionPreviewListDto(missionList));
    }

    // 내가 진행중인 미션 목록 조회 API
    @GetMapping("/members/{memberId}/challenging")
    @Operation(summary = "내가 진행중인 미션 목록 조회 API", description = "진행 중인 미션들을 조회하며, 페이징을 포함합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "사용자의 ID"),
            @Parameter(name = "page", description = "페이지 번호 (1부터 시작)")
    })
    public ApiResponse<MissionResponseDto.MissionPreviewListDto> getMyMissions(
            @PathVariable(name = "memberId") Long memberId,
            @CheckPage @RequestParam(name = "page") Integer page
    ) {
        Page<UserMission> missionList = missionService.getMyMissionList(memberId, page);

        // UserMission 리스트를 MissionPreviewListDto로 변환 (Converter 수정 필요할 수 있음)
        // 아래는 UserMission에서 Mission 정보를 꺼내 변환하는 방식입니다.
        return ApiResponse.onSuccess("내가 진행중인 미션 목록 조회",MissionConverter.toMissionPreviewListDto(missionList.map(UserMission::getMission)));
    }

    @PatchMapping("/members/{memberId}/{missionId}/complete")
    @Operation(summary = "미션 완료 처리 API", description = "진행 중인 미션을 완료 상태로 변경합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "사용자의 ID"),
            @Parameter(name = "missionId", description = "미션의 ID")
    })
    public ApiResponse<String> completeMission(
            @PathVariable(name = "memberId") Long memberId,
            @PathVariable(name = "missionId") Long missionId
    ) {
        missionService.completeMission(memberId, missionId);
        return ApiResponse.onSuccess("미션 완료!");
    }
}
