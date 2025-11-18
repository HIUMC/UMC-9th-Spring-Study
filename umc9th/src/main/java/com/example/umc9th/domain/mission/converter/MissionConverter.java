package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.mission.dto.MissionResponseDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.mapping.UserMission;

import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionResponseDTO.ChallengeMissionDTO toChallengeMissionDTO(UserMission userMission) {
        return MissionResponseDTO.ChallengeMissionDTO.builder()
                .userMissionId(userMission.getId())
                .createdAt(userMission.getCreatedAt())
                .build();
    }

    public static UserMission toUserMission(Mission mission, Member member) {
        UserMission userMission = UserMission.builder()
                .mission(mission)
                .member(member)
                .build();

        userMission.setMember(member);
        userMission.setMission(mission);

        return userMission;
    }
}