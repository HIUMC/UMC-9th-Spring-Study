package UMC.week4.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class MemberResDto {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDto {
        Long memberId;
        LocalDateTime createdAt;
    }

    @Builder
    public record LoginResultDTO(Long memberId, String accessToken) {}
}
