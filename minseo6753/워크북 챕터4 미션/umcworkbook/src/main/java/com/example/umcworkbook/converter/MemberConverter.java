package com.example.umcworkbook.converter;

import com.example.umcworkbook.dto.req.MemberReqDto;
import com.example.umcworkbook.dto.res.MemberResDto;
import com.example.umcworkbook.entity.Member;
import com.example.umcworkbook.entity.enums.Role;

public class MemberConverter {

    public static MemberResDto.JoinDto toJoinDto(
            Member member
    ) {
        return MemberResDto.JoinDto.builder()
                .memberId(member.getId())
                .createAt(member.getCreatedAt())
                .build();
    }

    public static Member toMember(
            MemberReqDto.JoinDto dto,
            String password,
            Role role
    ) {
        return Member.builder()
                .name(dto.name())
                .email(dto.email())
                .password(password)
                .role(role)
                .gender(dto.gender())
                .birth(dto.birth())
                .address(dto.address())
                .build();
    }

    public static MemberResDto.LoginDto toLoginDto(Member member, String accessToken) {
        return MemberResDto.LoginDto.builder()
                .memberId(member.getId())
                .accessToken(accessToken)
                .build();
    }
}
