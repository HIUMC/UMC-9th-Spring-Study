package UMC.week4.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AvailableMissionDto {
    private String missionTitle;
    private String storeName;
    private String missionContent;
    private Integer missionPoint;
    private String missionStatus;
}
