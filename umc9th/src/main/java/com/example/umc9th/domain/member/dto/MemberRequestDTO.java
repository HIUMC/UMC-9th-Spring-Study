package com.example.umc9th.domain.member.dto;

import lombok.Getter;

public class MemberRequestDTO {
    @Getter
    public static class SignUpDTO {
        private String name;
        private String gender;
        //... 기타 가입 정보
    }
}