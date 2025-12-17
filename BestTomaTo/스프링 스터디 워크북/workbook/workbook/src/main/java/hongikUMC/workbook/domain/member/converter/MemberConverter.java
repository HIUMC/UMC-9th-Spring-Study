package hongikUMC.workbook.domain.member.converter;

import hongikUMC.workbook.domain.member.dto.req.MemberReqDTO;
import hongikUMC.workbook.domain.member.dto.res.MemberResDTO;
import hongikUMC.workbook.domain.member.entity.Member;
import hongikUMC.workbook.domain.member.enums.Gender;
import hongikUMC.workbook.global.auth.enums.Role;
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

    // 서비스에서 로그인한 사용자에게 토큰 반환
    public static MemberResDTO.LoginDTO toLoginDTO(
        Member member,
        String accessToken
    ){
        return MemberResDTO.LoginDTO.builder()
                .memberId(member.getMember_id())
                .accesToken(accessToken)
                .build();
    }

    // DTO -> 엔티티
    // 리포지토리에 생성할 컬럼에 대한 정보를 전달
    // 리포지토리 계층에서 사용
    public static Member toMember(
            MemberReqDTO.JoinDTO memberDTO,
            String password, // 인증인가
            Role role // 인증인가
    ){
        return Member.builder()
                .name(memberDTO.name())
                .email(memberDTO.email())
                .password(password)
                .role(role)
                .gender(memberDTO.gender())
                .social_id(memberDTO.socialID())
                .social_pw(memberDTO.socialPW())
                .nickname(memberDTO.nickname())
                .build();
    }
}
