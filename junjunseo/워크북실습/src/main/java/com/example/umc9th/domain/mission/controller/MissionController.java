package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.MemberMissionReqDto;
import com.example.umc9th.domain.mission.dto.MemberMissionResDto;
import com.example.umc9th.domain.mission.dto.MissionReqDto;
import com.example.umc9th.domain.mission.dto.MissionResDto;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.exception.code.MissionSuccessCode;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.mission.service.MemberMissionService;
import com.example.umc9th.domain.mission.service.MissionQueryService;
import com.example.umc9th.domain.mission.service.MissionCommandService;
import com.example.umc9th.global.annotation.PageParam;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;
    private final MissionRepository missionRepository;

    @PostMapping
    public ApiResponse<MissionResDto> createMission(@RequestBody MissionReqDto request) {
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, missionCommandService.createMission(request));
    }

    private final MemberMissionService memberMissionService;

    @PostMapping("/challenge")
    public ApiResponse<MemberMissionResDto> challengeMission(
            @RequestBody MemberMissionReqDto request
    ) {
        return ApiResponse.onSuccess(
                GeneralSuccessCode.CREATED,
                memberMissionService.challenge(request)
        );
    }

    @Operation(
            summary = "내가 진행중인 미션 목록",
            description = "isComplete=false 상태의 미션을 페이징(10개)으로 조회합니다."
    )
    @GetMapping("/missions/my")
    public ApiResponse<Page<MissionResDto.MyOngoingMissionDto>> getMyOngoingMissions(
            @Parameter(description = "페이지 번호 (1부터 시작)", example = "1")
            @PageParam Integer page
    ) {
        Page<MissionResDto.MyOngoingMissionDto> result
                = missionQueryService.getMyOngoingMissions(page);

        return ApiResponse.onSuccess(MissionSuccessCode.FOUND, result);
    }

    @Operation(
            summary = "미션 완료 처리",
            description = "특정 미션을 완료 처리(isComplete=true)하고 완료된 미션 정보를 반환합니다."
    )
    @PutMapping("/missions/{missionId}/complete")
    public ApiResponse<MissionResDto.CompletedMissionDto> completeMission(
            @Parameter(description = "미션 ID", example = "1")
            @PathVariable Long missionId
    ) {
        MissionResDto.CompletedMissionDto result
                = missionCommandService.completeMission(missionId);

        return ApiResponse.onSuccess(MissionSuccessCode.COMPLETED, result);
    }

}
