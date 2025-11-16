package com.example.umc9th.domain.mission.dto;

import com.example.umc9th.domain.mission.entity.mapping.MemberMission;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberMissionResponseDto {

    private Long id;
    private Long missionId;
    private Long memberId;
    private boolean isComplete;

    public static MemberMissionResponseDto from(MemberMission mm) {
        return MemberMissionResponseDto.builder()
                .id(mm.getId())
                .missionId(mm.getMission().getId())
                .memberId(mm.getMember().getId())
                .isComplete(mm.isComplete())
                .build();
    }
}
