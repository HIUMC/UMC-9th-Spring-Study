package UMC.week4.converter;

import UMC.week4.domain.Mission;
import UMC.week4.domain.UserMission;
import UMC.week4.domain.enums.MissionStatus;
import UMC.week4.dto.MissionRequestDto;
import UMC.week4.dto.MissionRequestDto;
import UMC.week4.dto.MissionResponseDto;
import UMC.week4.dto.UserMissionResponseDto;
import UMC.week4.dto.UserMissionResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

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

    public static MissionResponseDto.MissionPreviewDto toMissionPreviewDto(Mission mission) {
        return MissionResponseDto.MissionPreviewDto.builder()
                .missionId(mission.getId())
                .storeName(mission.getStore().getTitle()) // Store 엔티티 접근
                .reward(mission.getPoint())
                .build();
    }

    public static MissionResponseDto.MissionPreviewListDto toMissionPreviewListDto(Page<Mission> missionList) {
        List<MissionResponseDto.MissionPreviewDto> missionPreviewDtos = missionList.stream()
                .map(MissionConverter::toMissionPreviewDto)
                .collect(Collectors.toList());

        return MissionResponseDto.MissionPreviewListDto.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreviewDtos.size())
                .missionList(missionPreviewDtos)
                .build();
    }
}
