package hello.umc9th.domain.member.converter;

import hello.umc9th.domain.member.dto.MemberReqDTO;
import hello.umc9th.domain.member.dto.MemberResDTO;
import hello.umc9th.domain.member.entity.Member;
import hello.umc9th.domain.member.enums.Role;

public class MemberConverter {

    //Entity -> DTO : DTO로 반환.
    public static MemberResDTO.JoinDTO toJoinDTO(Member member) {
        return MemberResDTO.JoinDTO.builder()
                .memberId(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .gender(member.getGender())
                .address(member.getAddress())
                .createdAt(member.getCreatedAt())
                .build();
    }


    //DTO -> Entity : Entity(member)로 반환.
    public static  Member toMember(MemberReqDTO.JoinDTO dto , String password, Role role) {
        return Member.builder() //컨테이너
                .name(dto.name())
                .email(dto.email()) //로그인 이메일
                .password(password) //로그인 비밀번호
                .role(role) //사용자 역할
                .gender(dto.gender())
                .address(dto.address())
                .build();//완료
    }
}
