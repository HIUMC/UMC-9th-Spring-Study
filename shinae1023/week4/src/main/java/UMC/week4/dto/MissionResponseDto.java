package UMC.week4.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

public class MissionResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateMissionDto {
        private Long missionId;
        private Long storeId;
        private String content;
        private Integer reward;
        private LocalDate deadline;
    }
}