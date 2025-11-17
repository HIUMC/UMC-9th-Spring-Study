package UMC.week4.dto;

import UMC.week4.domain.enums.MissionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

public class UserMissionResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ChallengeMissionDTO {
        private Long userMissionId;
        private Long memberId;
        private Long missionId;
        private MissionStatus status;
        private LocalDateTime createdAt;
    }
}