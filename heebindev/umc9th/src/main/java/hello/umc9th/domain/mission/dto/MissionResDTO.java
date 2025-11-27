package hello.umc9th.domain.mission.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

public class MissionResDTO {


    // 목록의 개별 미션 정보를 담는 DTO
    @Getter
    @Builder
    public static class MissionPreviewDTO {
        private Long missionId;
        private String missionContent;
        private int point;
        private LocalDateTime missionDeadline;
    }

    // 페이징 정보 + 미션 리스트 DTO
    @Getter
    @Builder
    public static class MissionPreviewListDTO {
        private List<MissionPreviewDTO> missionList;
        private Integer listSize;
        private Integer totalPage;
        private Long totalElements;
        private Boolean isFirst;
        private Boolean isLast;
    }
}