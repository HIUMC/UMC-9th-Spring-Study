package hello.umc9th.domain.member.service.command;

import hello.umc9th.domain.member.dto.MemberReqDTO;
import hello.umc9th.domain.member.dto.MemberResDTO;

public interface MemberCommandService {
    //회원 가입
    MemberResDTO.JoinDTO signup(MemberReqDTO.JoinDTO dto);
}
