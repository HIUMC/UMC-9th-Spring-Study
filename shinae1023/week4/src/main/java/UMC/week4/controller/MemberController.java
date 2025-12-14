package UMC.week4.controller;

import UMC.week4.dto.MemberReqDto;
import UMC.week4.dto.MemberResDto;
import UMC.week4.global.apiPayload.ApiResponse;
import UMC.week4.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/sign-up")
    public ApiResponse<MemberResDto.JoinResultDto> join(@RequestBody @Valid MemberReqDto.JoinDto request) {
        MemberResDto.JoinResultDto result = memberService.join(request);
        return ApiResponse.onSuccess("회원가입 성공",result);
    }

    @PostMapping("/login")
    public ApiResponse<MemberResDto.LoginResultDTO> login(@RequestBody @Valid MemberReqDto.LoginDTO request) {
        MemberResDto.LoginResultDTO result = memberService.login(request);
        return ApiResponse.onSuccess("로그인 성공",result);
    }
}
