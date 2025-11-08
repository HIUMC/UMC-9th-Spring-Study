package UMC.week4.dto;

import UMC.week4.domain.enums.MissionStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class InprogressMissionDto {
    private String storeName;
    private String missionContent;
    private Integer missionPoint;
    private MissionStatus missionStatus;
}
