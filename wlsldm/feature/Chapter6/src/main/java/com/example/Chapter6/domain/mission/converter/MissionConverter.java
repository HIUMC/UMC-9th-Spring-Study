package com.example.Chapter6.domain.mission.converter;

import com.example.Chapter6.domain.mission.dto.response.MissionResDTO;
import com.example.Chapter6.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;

public class MissionConverter {

    // result -> DTO
    public static MissionResDTO.MissionPreViewListDTO toMissionPreviewListDTO(
            Page<Mission> result
    ){
        return MissionResDTO.MissionPreViewListDTO.builder()
                .missionList(result.getContent().stream()
                        .map(MissionConverter::toMissionPreviewDTO)
                        .toList()
                )
                .listSize(result.getSize())
                .totalPage(result.getTotalPages())
                .totalElements(result.getTotalElements())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .build();
    }

    public static MissionResDTO.MissionPreViewDTO toMissionPreviewDTO(
            Mission mission
    ){
        return MissionResDTO.MissionPreViewDTO.builder()
                .name(mission.getName())
                .expiredAt(mission.getExpiredAt())
                .content(mission.getContent())
                .point(mission.getPoint())
                .storeName(mission.getStore().getName())
                .build();
    }
}
