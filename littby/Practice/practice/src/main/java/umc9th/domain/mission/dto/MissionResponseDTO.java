package umc9th.domain.mission.dto;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.List;

public class MissionResponseDTO {

    @Builder
    @Getter
    public static class MissionListDTO {
        List<MissionResponseDTO> missionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }



    @Builder
    @Getter
    public static class ChallengeMissionResultDTO {
        Long userMissionId;
        String restaurantName;
        String missionStatus;
        LocalDateTime createdAt;
        Integer completedCount;
        Integer missionPoint;
    }
}