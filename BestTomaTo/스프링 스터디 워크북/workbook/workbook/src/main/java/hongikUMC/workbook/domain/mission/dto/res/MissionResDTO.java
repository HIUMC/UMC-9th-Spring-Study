package hongikUMC.workbook.domain.mission.dto.res;

import hongikUMC.workbook.domain.mission.enums.Status;
import lombok.Builder;

import java.time.LocalDateTime;

public class MissionResDTO {

    @Builder
    public record saveMissionDTO(
            Long mission_id,
            LocalDateTime created_at
    ){}

    @Builder
    public record startMissionDTO(
            Long mission_id,
            Status status,
            LocalDateTime updated_at
    ){}
}
