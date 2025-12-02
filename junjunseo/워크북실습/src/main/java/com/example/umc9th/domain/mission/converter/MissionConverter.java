package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.mission.dto.MemberMissionResDto;
import com.example.umc9th.domain.mission.dto.MissionResDto;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.mapping.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

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

    public static Page<MissionResDto.StoreMissionDto> toStoreMissionPage(Page<Mission> missionPage) {

        List<MissionResDto.StoreMissionDto> content = missionPage.getContent()
                .stream()
                .map(mission -> MissionResDto.StoreMissionDto.builder()
                        .missionId(mission.getId())
                        .conditional(mission.getConditional())
                        .point(mission.getPoint())
                        .deadline(mission.getDeadline())
                        .build()
                )
                .toList();

        return new PageImpl<>(
                content,
                missionPage.getPageable(),
                missionPage.getTotalElements()
        );
    }

    public static Page<MissionResDto.MyOngoingMissionDto> toMyOngoingMissionPage(
            Page<MemberMission> memberMissionPage
    ) {

        List<MissionResDto.MyOngoingMissionDto> content = memberMissionPage.getContent()
                .stream()
                .map(mm -> MissionResDto.MyOngoingMissionDto.builder()
                        .missionId(mm.getMission().getId())
                        .conditional(mm.getMission().getConditional())
                        .point(mm.getMission().getPoint())
                        .deadline(mm.getMission().getDeadline())
                        .storeId(mm.getMission().getStore().getId())
                        .storeName(mm.getMission().getStore().getName())
                        .build()
                )
                .toList();

        return new PageImpl<>(content,
                memberMissionPage.getPageable(),
                memberMissionPage.getTotalElements());
    }

    public static MissionResDto.CompletedMissionDto toCompletedMissionDto(MemberMission mm) {

        return MissionResDto.CompletedMissionDto.builder()
                .missionId(mm.getMission().getId())
                .conditional(mm.getMission().getConditional())
                .point(mm.getMission().getPoint())
                .deadline(mm.getMission().getDeadline())
                .storeId(mm.getMission().getStore().getId())
                .storeName(mm.getMission().getStore().getName())
                .isComplete(mm.isComplete())
                .build();
    }
}
