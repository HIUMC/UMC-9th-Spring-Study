package umc9th.domain.mission.dto;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

public class MissionResponseDTO {

    @Builder
    @Getter
    public static class ChallengeMissionResultDTO {
        Long userMissionId;
        String missionStatus;
        LocalDateTime createdAt;
    }
}