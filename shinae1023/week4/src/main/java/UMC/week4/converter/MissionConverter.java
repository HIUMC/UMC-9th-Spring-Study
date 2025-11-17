package UMC.week4.converter;

import UMC.week4.domain.Mission;
import UMC.week4.domain.UserMission;
import UMC.week4.domain.enums.MissionStatus;
import UMC.week4.dto.MissionRequestDto;
import UMC.week4.dto.MissionRequestDto;
import UMC.week4.dto.MissionResponseDto;
import UMC.week4.dto.UserMissionResponseDto;
import UMC.week4.dto.UserMissionResponseDto;

public class MissionConverter {

    // API 2: 가게에 미션 추가하기 (Request DTO -> Mission Entity)
    public static Mission toMission(MissionRequestDto.CreateMissionDto request) {
        return Mission.builder()
                .content(request.getContent())
                .point(request.getPoint())
                .build();
    }

    // API 2: 가게에 미션 추가하기 (Mission Entity -> Response DTO)
    public static MissionResponseDto.CreateMissionDto toCreateMissionDTO(Mission mission) {
        return MissionResponseDto.CreateMissionDto.builder()
                .missionId(mission.getId())
                .storeId(mission.getStore().getId())
                .content(mission.getContent())
                .reward(mission.getPoint())
                .build();
    }

    // API 1: 미션 도전하기 (초기 UserMission 생성)
    public static UserMission toUserMission(Mission mission) {
        return UserMission.builder()
                .isComplete(MissionStatus.CHALLENGING) // 도전 시작 시 상태
                .mission(mission)
                .build();
    }

    // API 1: 미션 도전하기 (UserMission Entity -> Response DTO)
    public static UserMissionResponseDto.ChallengeMissionDTO toChallengeMissionDTO(UserMission userMission) {
        return UserMissionResponseDto.ChallengeMissionDTO.builder()
                .userMissionId(userMission.getId())
                .memberId(userMission.getMember().getId())
                .missionId(userMission.getMission().getId())
                .status(userMission.getIsComplete())
                .build();
    }
}
