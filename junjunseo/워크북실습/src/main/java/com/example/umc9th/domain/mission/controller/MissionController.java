package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.MemberMissionReqDto;
import com.example.umc9th.domain.mission.dto.MemberMissionResDto;
import com.example.umc9th.domain.mission.dto.MissionReqDto;
import com.example.umc9th.domain.mission.dto.MissionResDto;
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
    public ApiResponse<MissionResDto> createMission(@RequestBody MissionReqDto request) {
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, missionService.createMission(request));
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
}
