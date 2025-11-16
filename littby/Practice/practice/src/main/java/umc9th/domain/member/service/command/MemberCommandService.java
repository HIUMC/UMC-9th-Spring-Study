package umc9th.domain.member.service.command;

import umc9th.domain.member.dto.MemberResDTO;
import umc9th.domain.member.entity.Member;

public interface MemberCommandService {

    MemberResDTO.JoinDTO signup (
            MemberResDTO.JoinDTO dto
            );
}
