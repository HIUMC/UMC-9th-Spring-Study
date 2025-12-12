package hongikUMC.workbook.domain.member.controller;

import hongikUMC.workbook.domain.member.dto.req.MemberReqDTO;
import hongikUMC.workbook.domain.member.dto.res.MemberResDTO;
import hongikUMC.workbook.domain.member.exception.code.MemberSuccessCode;
import hongikUMC.workbook.domain.member.service.MemberCommandService;
import hongikUMC.workbook.global.apiPayload.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("member")
public class MemberController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/signup")
    public ApiResponse<MemberResDTO.JoinDTO> memberSignUp(
            @RequestBody @Valid MemberReqDTO.JoinDTO joinDTO
    ){
        return ApiResponse.onSuccess(MemberSuccessCode.OK, memberCommandService.signUp(joinDTO));
    }
}
