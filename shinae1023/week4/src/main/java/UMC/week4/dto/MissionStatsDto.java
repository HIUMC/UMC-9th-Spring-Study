package UMC.week4.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MissionStatsDto {
    private long totalMissions;     // 전체 미션 수
    private long completedMissions; // 완료한 미션 수
}
