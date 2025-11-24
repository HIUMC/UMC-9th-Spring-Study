package UMC.week4.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

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

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreviewDto {
        private Long missionId;
        private String storeName;
        private String missionSpec;
        private Integer reward;
        private String status; // UserMission이 없는 경우 "NOT_CHALLENGING" 등으로 처리 가능
        private LocalDate deadline;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreviewListDto {
        private List<MissionPreviewDto> missionList;
        private Integer listSize;
        private Integer totalPage;
        private Long totalElements;
        private Boolean isFirst;
        private Boolean isLast;
    }
}