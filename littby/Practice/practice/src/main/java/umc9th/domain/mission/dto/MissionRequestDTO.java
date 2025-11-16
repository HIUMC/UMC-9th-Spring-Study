package umc9th.domain.mission.dto;

import lombok.Getter;

public class MissionRequestDTO {

    @Getter
    public static class ChallengeMissionDTO {
        private Long missionId; // 도전할 미션의 ID
    }
}
