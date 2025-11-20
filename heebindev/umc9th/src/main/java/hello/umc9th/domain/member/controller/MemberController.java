package hello.umc9th.domain.member.controller;

import hello.umc9th.domain.member.dto.MemberReqDTO;
import hello.umc9th.domain.member.dto.MemberResDTO;
import hello.umc9th.domain.member.exception.code.MemberSuccessCode;
import hello.umc9th.domain.member.service.command.MemberCommandService;
import hello.umc9th.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController//컨트롤러가 JSON 형태로 응답한다
@RequiredArgsConstructor //final 붙은 필드들에 대해 생성자를 자동 생성해줌.
public class MemberController {

    private final MemberCommandService memberCommandService;
    //DTO를 정의한 service

    //회원가입
    @PostMapping("/auth/users/signup") //POST 요청을 받을 URL
    //파라미터로 JSON 바디의 요청을 JoinDTO로 변환하여 받음
    public ApiResponse<MemberResDTO.JoinDTO> signUp(@RequestBody MemberReqDTO.JoinDTO dto){
        return ApiResponse.onSuccess(MemberSuccessCode.Found, memberCommandService.signup(dto));
    }//성공코드를 반환
}
