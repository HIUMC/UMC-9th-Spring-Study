package hello.umc9th.domain.member.dto;

import hello.umc9th.domain.member.enums.Gender;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MemberResDTO {

    @Builder
    public record JoinDTO(
            Long memberId,
            String name,
            String email,
            Gender gender,
            String address,
            LocalDateTime createdAt
    ){}

    // 로그인
    @Builder
    public record LoginDTO(
            Long memberId,
            String email,
            String accessToken
    ){}
}
