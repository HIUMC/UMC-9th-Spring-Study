package com.example.umc9th.domain.mission.dto;

import com.example.umc9th.domain.mission.entity.Mission;
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
}
