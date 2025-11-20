package hello.umc9th.domain.mission.dto;

import lombok.Builder;
import lombok.Getter;

public class MemberMissionResDTO {

    @Getter
    @Builder
    public static class MemberMissionInfo {
        private Long id;
        private String memberName;
        private String missionContent;
        private String status;
    }
}