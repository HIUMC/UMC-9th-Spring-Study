package com.example.umc9th.domain.mission.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class MissionResDto {
    private Long id;
    private LocalDate deadline;
    private String conditional;
    private Integer point;
    private Long storeId;

    @Builder
    public record StoreMissionDto(
            Long missionId,
            String conditional,
            Integer point,
            LocalDate deadline
    ) {}

    @Builder
    public record MyOngoingMissionDto(
            Long missionId,
            String conditional,
            Integer point,
            LocalDate deadline,
            Long storeId,
            String storeName
    ) {}

    @Builder
    public record CompletedMissionDto(
            Long missionId,
            String conditional,
            Integer point,
            LocalDate deadline,
            Long storeId,
            String storeName,
            Boolean isComplete
    ) {}
}
