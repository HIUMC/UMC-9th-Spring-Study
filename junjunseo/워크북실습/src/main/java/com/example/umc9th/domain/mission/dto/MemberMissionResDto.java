package com.example.umc9th.domain.mission.dto;

import com.example.umc9th.domain.mission.entity.mapping.MemberMission;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberMissionResDto {

    private Long id;
    private Long missionId;
    private Long memberId;
    private boolean isComplete;

}
