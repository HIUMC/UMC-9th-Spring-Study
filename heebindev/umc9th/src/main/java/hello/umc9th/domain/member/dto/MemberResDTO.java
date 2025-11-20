package hello.umc9th.domain.member.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MemberResDTO {

    @Builder
    public record JoinDTO(
            Long memberId,
            LocalDateTime createdAt
    ){}
}
