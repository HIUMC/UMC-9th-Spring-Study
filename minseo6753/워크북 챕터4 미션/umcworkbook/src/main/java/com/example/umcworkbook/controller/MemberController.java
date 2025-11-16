package com.example.umcworkbook.controller;

import com.example.umcworkbook.apiPayload.ApiResponse;
import com.example.umcworkbook.apiPayload.code.MemberSuccessCode;
import com.example.umcworkbook.dto.req.MemberReqDto;
import com.example.umcworkbook.dto.res.MemberResDto;
import com.example.umcworkbook.service.command.MemberCommandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/sign-up")
    public ApiResponse<MemberResDto.JoinDto> signUp(
            @RequestBody @Valid MemberReqDto.JoinDto dto
    ){
        return ApiResponse.onSuccess(MemberSuccessCode.FOUND, memberCommandService.signup(dto));
    }
}
