package com.example.umc9th.domain.member.converter;

import com.example.umc9th.domain.member.dto.MemberRequestDTO;
import com.example.umc9th.domain.member.dto.MemberResponseDTO;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.enums.Gender;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MemberConverter {

    public static Member toMember(MemberRequestDTO request){

        Gender gender = Gender.valueOf(request.getGender().toUpperCase());

        Calendar cal = Calendar.getInstance();
        cal.set(request.getBirthYear(), request.getBirthMonth() - 1, request.getBirthDay());
        Date birthDate = cal.getTime();

        return Member.builder()
                .name(request.getName())
                .gender(gender)
                .dateOfBirth(birthDate)
                .address(request.getAddress())
                .detailAddress(request.getDetailAddress())
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
