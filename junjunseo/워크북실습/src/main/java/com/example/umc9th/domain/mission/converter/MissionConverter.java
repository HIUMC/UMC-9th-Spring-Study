package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.mission.dto.MemberMissionResDto;
import com.example.umc9th.domain.mission.dto.MissionResDto;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.mapping.MemberMission;

public class MissionConverter {

    public static MemberMissionResDto toMemberMissionResDto(MemberMission mm) {
        return MemberMissionResDto.builder()
                .id(mm.getId())
                .missionId(mm.getMission().getId())
                .memberId(mm.getMember().getId())
                .isComplete(mm.isComplete())
                .build();
    }

    public static MissionResDto toMissionResDto(Mission mission) {
        return MissionResDto.builder()
                .id(mission.getId())
                .deadline(mission.getDeadline())
                .conditional(mission.getConditional())
                .point(mission.getPoint())
                .storeId(mission.getStore().getId())
                .build();
    }
}
