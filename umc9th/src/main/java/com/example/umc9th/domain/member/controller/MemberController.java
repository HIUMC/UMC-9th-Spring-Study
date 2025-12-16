package com.example.umc9th.domain.member.controller;

import com.example.umc9th.domain.member.converter.MemberConverter;
import com.example.umc9th.domain.member.dto.MemberRequestDTO;
import com.example.umc9th.domain.member.dto.MemberResponseDTO;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.service.MemberService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.status.MemberSuccessCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/sign-up")
    public ApiResponse<MemberResponseDTO.SignUpResultDTO> signUp(@Valid @RequestBody MemberRequestDTO.JoinDTO request){
        Member member = memberService.signUp(request);
        // ApiResponse.onSuccess -> ApiResponse.of 로 변경
        return ApiResponse.of(MemberSuccessCode.MEMBER_JOIN_SUCCESS, MemberConverter.toSignUpResultDTO(member));
    }

    // 로그인 API
    @PostMapping("/login")
    public ApiResponse<MemberResponseDTO.LoginDTO> login(
            @RequestBody @Valid MemberRequestDTO.LoginDTO dto
    ){
        // ApiResponse.onSuccess -> ApiResponse.of 로 변경
        return ApiResponse.of(MemberSuccessCode.MEMBER_LOGIN_SUCCESS, memberService.login(dto));
    }
}