package hongikUMC.workbook.domain.member.converter;

import hongikUMC.workbook.domain.member.dto.req.MemberReqDTO;
import hongikUMC.workbook.domain.member.dto.res.MemberResDTO;
import hongikUMC.workbook.domain.member.entity.Member;
import hongikUMC.workbook.domain.member.enums.Gender;
import lombok.Builder;

public class MemberConverter {

    // 엔티티 -> DTO
    // 리포지토리에서 생성된 객체를 DTO로 변환
    // 서비스 계층에서 사용
    public static MemberResDTO.JoinDTO toJoinDTO(
            Member member
    ){
        return MemberResDTO.JoinDTO.builder()
                .memberId(member.getMember_id())
                .createdAt(member.getCreated_at())
                .build();
    }

    // DTO -> 엔티티
    // 리포지토리에 생성할 컬럼에 대한 정보를 전달
    // 리포지토리 계층에서 사용
    public static Member toMember(
            MemberReqDTO.JoinDTO memberDTO
    ){
        return Member.builder()
                .name(memberDTO.name())
                .gender(memberDTO.gender())
                .social_id(memberDTO.socialID())
                .social_pw(memberDTO.socialPW())
                .nickname(memberDTO.nickname())
                .build();
    }
}
