package com.example.umc9th.domain.mission.dto;

import com.example.umc9th.domain.mission.entity.Mission;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class MissionResponseDto {
    private Long id;
    private LocalDate deadline;
    private String conditional;
    private Integer point;
    private Long storeId;

    public static MissionResponseDto from(Mission mission) {
        return MissionResponseDto.builder()
                .id(mission.getId())
                .deadline(mission.getDeadline())
                .conditional(mission.getConditional())
                .point(mission.getPoint())
                .storeId(mission.getStore().getId())
                .build();
    }
}
