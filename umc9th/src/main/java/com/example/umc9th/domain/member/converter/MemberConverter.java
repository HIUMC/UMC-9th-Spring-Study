package com.example.umc9th.domain.member.converter;

import com.example.umc9th.domain.member.dto.MemberRequestDTO;
import com.example.umc9th.domain.member.dto.MemberResponseDTO;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.enums.Gender;

public class MemberConverter {
    public static Member toMember(MemberRequestDTO.SignUpDTO request) {
        Gender gender = null;
        // 문자열로부터 Gender Enum 값을 안전하게 변환
        if (request.getGender()!= null) {
            gender = Gender.valueOf(request.getGender().toUpperCase());
        }

        return Member.builder()
                .name(request.getName())
                .gender(gender)
                .build();
    }

    public static MemberResponseDTO.SignUpResultDTO toSignUpResultDTO(Member member) {
        return MemberResponseDTO.SignUpResultDTO.builder()
                .memberId(member.getId())
                .createdAt(member.getCreatedAt())
                .build();
    }
}
