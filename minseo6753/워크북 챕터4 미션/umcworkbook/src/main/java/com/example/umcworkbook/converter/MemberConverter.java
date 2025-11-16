package com.example.umcworkbook.converter;

import com.example.umcworkbook.dto.req.MemberReqDto;
import com.example.umcworkbook.dto.res.MemberResDto;
import com.example.umcworkbook.entity.Member;

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
            MemberReqDto.JoinDto dto
    ) {
        return Member.builder()
                .name(dto.name())
                .gender(dto.gender())
                .birth(dto.birth())
                .address(dto.address())
                .build();
    }
}
