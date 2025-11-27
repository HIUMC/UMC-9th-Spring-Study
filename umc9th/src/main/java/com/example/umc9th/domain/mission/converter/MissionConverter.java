package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.mission.dto.MissionResponseDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.mapping.UserMission;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {

    public static MissionResponseDTO.MissionPreviewDTO toMissionPreviewDTO(Mission mission) {
        return MissionResponseDTO.MissionPreviewDTO.builder()
                .missionId(mission.getMissionId())
                .point(mission.getPoint())
                .deadline(mission.getDeadline())
                .conditional(mission.getConditional())
                .title(mission.getTitle())
                .build();
    }

    public static MissionResponseDTO.MissionListDTO toMissionListDTO(Page<Mission> missionList) {
        List<MissionResponseDTO.MissionPreviewDTO> missionPreviewDTOList = missionList.getContent().stream()
                .map(MissionConverter::toMissionPreviewDTO).collect(Collectors.toList());

        return MissionResponseDTO.MissionListDTO.builder()
                .missionList(missionPreviewDTOList)
                .isFirst(missionList.isFirst())
                .isLast(missionList.isLast())
                .totalElements(missionList.getTotalElements())
                .totalPage(missionList.getTotalPages())
                .listSize(missionPreviewDTOList.size())
                .build();
    }

    public static MissionResponseDTO.ChallengeMissionDTO toChallengeMissionDTO(UserMission userMission) {
        return MissionResponseDTO.ChallengeMissionDTO.builder()
                .userMissionId(userMission.getId())
                .missionId(userMission.getMission().getMissionId())
                .build();
    }

    public static UserMission toUserMission(Mission mission, Member member) {
        return UserMission.builder()
                .mission(mission)
                .member(member)
                .build();
    }

}