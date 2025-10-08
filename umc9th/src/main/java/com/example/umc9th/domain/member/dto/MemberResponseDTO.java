// domain/member/dto/MemberResponseDTO.java
package com.example.umc9th.domain.member.dto;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

public class MemberResponseDTO {
    @Builder
    @Getter
    public static class SignUpResultDTO {
        private Long memberId;
        private LocalDateTime createdAt;
    }
}