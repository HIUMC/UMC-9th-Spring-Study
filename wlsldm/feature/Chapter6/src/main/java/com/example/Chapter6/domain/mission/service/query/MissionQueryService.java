package com.example.Chapter6.domain.mission.service.query;

import com.example.Chapter6.domain.mission.dto.response.MissionResDTO;
import jakarta.validation.Valid;

public interface MissionQueryService {
    MissionResDTO.MissionPreViewListDTO findMission(
            String storeName,
            Integer page
    );

    MissionResDTO.MissionPreViewListDTO findMyMission(Long userId, @Valid Integer page);
}
