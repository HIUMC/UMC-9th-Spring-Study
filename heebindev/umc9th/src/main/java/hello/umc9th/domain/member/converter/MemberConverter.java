package hello.umc9th.domain.member.converter;

import hello.umc9th.domain.member.dto.MemberReqDTO;
import hello.umc9th.domain.member.dto.MemberResDTO;
import hello.umc9th.domain.member.entity.Member;

public class MemberConverter {

    //Entity -> DTO : DTO로 반환.
    public static MemberResDTO.JoinDTO toJoinDTO(Member member) {
        return MemberResDTO.JoinDTO.builder() //빌더 컨테이너
                .memberId(member.getId())
                .createdAt(member.getCreatedAt())
                .build();
    }

    //DTO -> Entity : Entity(member)로 반환.
    public static  Member toMember(MemberReqDTO.JoinDTO dto) {
        return Member.builder() //컨테이너
                .name(dto.name())
                .gender(dto.gender())
                .address(dto.address())
                .build();//완료
    }
}
