package hello.umc9th.domain.mission.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class MemberMissionResDTO {

    @Getter
    @Builder
    public static class MemberMissionInfo {
        private Long id;
        private String memberName;
        private String missionContent;
        private String status;
    }

    //진행중인 미션 목록 + 페이징 정보 DTO
    @Getter
    @Builder
    public static class MemberMissionPreviewListDTO {
        private List<MemberMissionInfo> missionList;
        private Integer listSize;
        private Integer totalPage;
        private Long totalElements;
        private Boolean isFirst;
        private Boolean isLast;
    }
}