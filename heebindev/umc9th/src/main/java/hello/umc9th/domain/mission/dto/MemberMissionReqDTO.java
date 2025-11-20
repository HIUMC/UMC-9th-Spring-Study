package hello.umc9th.domain.mission.dto;

import lombok.Builder;
import lombok.Getter;
public class MemberMissionReqDTO {

    @Getter
    @Builder
    public static class CreateMemberMissionDTO {
        private Long missionId; // 어떤 미션인지
        private Long memberId;  // 로그인 없으니 입력받거나 하드코딩ㅇ
    }
}