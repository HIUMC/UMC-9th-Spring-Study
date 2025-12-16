package com.example.umc9th.domain.member.converter;

import com.example.umc9th.domain.member.dto.MemberRequestDTO;
import com.example.umc9th.domain.member.dto.MemberResponseDTO;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.enums.Gender;
import com.example.umc9th.domain.member.enums.Role;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MemberConverter {

// toMember 메서드의 파라미터를 MemberRequestDTO.JoinDTO로 변경합니다.
public static Member toMember(MemberRequestDTO.JoinDTO request, String password, Role role){

    // request.getGender() -> request.gender() 로 변경합니다.
    Gender gender = null;
    if (request.gender() != null) {
        gender = Gender.valueOf(request.gender().toUpperCase());
    }

    Date birthDate = null;
    if (request.birthYear() != null && request.birthMonth() != null && request.birthDay() != null) {
        Calendar cal = Calendar.getInstance();
        // request.getBirthYear() -> request.birthYear() 로 변경합니다.
        cal.set(request.birthYear(), request.birthMonth() - 1, request.birthDay());
        birthDate = cal.getTime();
    }

    return Member.builder()
            // request.getEmail() -> request.email() 로 변경합니다.
            .email(request.email())
            .password(password)
            .role(role)
            .name(request.name())
            .gender(gender)
            .dateOfBirth(birthDate)
            .address(request.address())
            .detailAddress(request.detailAddress())
            .memberFoodList(new ArrayList<>())
            .build();
}


    public static MemberResponseDTO.SignUpResultDTO toSignUpResultDTO(Member member){
        return MemberResponseDTO.SignUpResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
