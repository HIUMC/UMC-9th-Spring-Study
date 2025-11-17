package com.example.umcworkbook.controller;

import com.example.umcworkbook.apiPayload.ApiResponse;
import com.example.umcworkbook.apiPayload.code.success.GeneralSuccessCode;
import com.example.umcworkbook.dto.res.MemberMissionResDto;
import com.example.umcworkbook.service.command.MemberMissionCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberMissionController {

    private final MemberMissionCommandService memberMissionCommandService;

    //가게의 미션을 도전 중인 미션에 추가(미션 도전하기)
    @PostMapping("/users/{userId}/missions/{missionId}")
    public ApiResponse<MemberMissionResDto.searchDto> createMemberMission(
            @PathVariable Long userId,
            @PathVariable Long missionId
    ){
        return ApiResponse.onSuccess(
                GeneralSuccessCode.CREATED,
                memberMissionCommandService.createMemberMission(userId, missionId)
        );
    }
}
