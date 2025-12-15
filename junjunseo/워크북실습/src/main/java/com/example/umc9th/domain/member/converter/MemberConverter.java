package com.example.umc9th.domain.member.converter;

import com.example.umc9th.domain.member.dto.MemberReqDto;
import com.example.umc9th.domain.member.dto.MemberResDto;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.enums.Role;

public class MemberConverter {
    // Entity -> DTO
    public static MemberResDto.JoinDto toJoinDTO(Member member) {
        return MemberResDto.JoinDto.builder()
                .memberId(member.getId())
                .createAt(member.getCreatedAt())
                .build();
    }

    // DTO -> Entity
    public static Member toMember(MemberReqDto.JoinDto dto, String password, Role role){
        return Member.builder()
                .name(dto.name())
                .email(dto.email())
                .password(password)
                .role(role)
                .birth(dto.birth())
                .address(dto.address())
                .detailAddress(dto.specAddress())
                .gender(dto.gender())
                .build();
    }

    public static MemberResDto.LoginDto toLoginDto(Member member, String accessToken) {
        return MemberResDto.LoginDto.builder()
                .memberId(member.getId())
                .accessToken(accessToken)
                .build();
    }
}
