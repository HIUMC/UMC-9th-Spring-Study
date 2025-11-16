package com.example.umc9th.domain.mission.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MissionCreateRequestDto {

    private Long storeId;
    private LocalDate deadline;
    private String conditional;
    private Integer point;
}
