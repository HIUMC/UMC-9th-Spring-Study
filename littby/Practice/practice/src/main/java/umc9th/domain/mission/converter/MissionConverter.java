package umc9th.domain.mission.converter;

import umc9th.domain.mission.entity.UserMission;
import umc9th.domain.mission.dto.MissionResponseDTO;
import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionResponseDTO.ChallengeMissionResultDTO toChallengeMissionResultDTO(UserMission userMission) {
        return MissionResponseDTO.ChallengeMissionResultDTO.builder()
                .userMissionId(userMission.getId())
                .missionStatus(userMission.getStatus().toString())
                .createdAt(userMission.getCreatedAt())
                .build();
    }
}
