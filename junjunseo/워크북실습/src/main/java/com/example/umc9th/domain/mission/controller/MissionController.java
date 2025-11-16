package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.MemberMissionCreateRequest;
import com.example.umc9th.domain.mission.dto.MemberMissionResponseDto;
import com.example.umc9th.domain.mission.dto.MissionCreateRequestDto;
import com.example.umc9th.domain.mission.dto.MissionResponseDto;
import com.example.umc9th.domain.mission.service.MemberMissionService;
import com.example.umc9th.domain.mission.service.MissionService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionService missionService;

    @PostMapping
    public ApiResponse<MissionResponseDto> createMission(@RequestBody MissionCreateRequestDto request) {
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, missionService.createMission(request));
    }

    private final MemberMissionService memberMissionService;

    @PostMapping("/challenge")
    public ApiResponse<MemberMissionResponseDto> challengeMission(
            @RequestBody MemberMissionCreateRequest request
    ) {
        return ApiResponse.onSuccess(
                GeneralSuccessCode.CREATED,
                memberMissionService.challenge(request)
        );
    }
}
