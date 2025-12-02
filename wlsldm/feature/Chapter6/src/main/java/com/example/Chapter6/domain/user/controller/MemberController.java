package com.example.Chapter6.domain.user.controller;

import com.example.Chapter6.domain.user.dto.request.MemberReqDTO;
import com.example.Chapter6.domain.user.dto.response.MemberResDTO;
import com.example.Chapter6.domain.user.exception.code.MemberSuccessCode;
import com.example.Chapter6.domain.user.service.command.MemberCommandService;
import com.example.Chapter6.domain.user.service.command.MemberMissionCommandService;
import com.example.Chapter6.global.apiPayload.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberCommandService memberCommandService;
    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/sign-up")
    public ApiResponse<MemberResDTO.JoinDTO> singUp(
            @RequestBody @Valid MemberReqDTO.JoinDTO dto
    ){
        return ApiResponse.onSuccess(MemberSuccessCode.FOUND,
                memberCommandService.signup(dto));
    }

    @PostMapping("members/mission")
    public ApiResponse<MemberResDTO.AddMissionDTO> addMission(
            @RequestBody MemberReqDTO.AddMissionDTO dto
    ){
        return ApiResponse.onSuccess(
                MemberSuccessCode.FOUND,
                memberMissionCommandService.addMission(dto)
        );
    }
}
