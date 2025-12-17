package hongikUMC.workbook.domain.member.controller;

import hongikUMC.workbook.domain.member.dto.req.MemberReqDTO;
import hongikUMC.workbook.domain.member.dto.res.MemberResDTO;
import hongikUMC.workbook.domain.member.exception.code.MemberSuccessCode;
import hongikUMC.workbook.domain.member.service.MemberCommandService;
import hongikUMC.workbook.domain.member.service.MemberQueryService;
import hongikUMC.workbook.global.apiPayload.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    @PostMapping("/signup")
    public ApiResponse<MemberResDTO.JoinDTO> memberSignUp(
            @RequestBody @Valid MemberReqDTO.JoinDTO joinDTO
    ){
        return ApiResponse.onSuccess(MemberSuccessCode.OK_SIGNUP, memberCommandService.signUp(joinDTO));
    }

    @PostMapping("/login")
    public ApiResponse<MemberResDTO.LoginDTO> memberLogin(
            @RequestBody @Valid MemberReqDTO.LoginDTO loginDTO
    ){
        return ApiResponse.onSuccess(MemberSuccessCode.OK_LOGIN, memberQueryService.login(loginDTO));
    }
}
