package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.mission.dto.MissionResponseDTO;
import org.springframework.data.domain.Page;

public interface MissionQueryService {
    MissionResponseDTO.ChallengingMissionListDTO getChallengingMissionList(Long memberId, Integer page);
}