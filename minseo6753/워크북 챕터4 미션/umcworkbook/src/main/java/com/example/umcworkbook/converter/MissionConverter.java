package com.example.umcworkbook.converter;

import com.example.umcworkbook.dto.res.MissionResDto;
import com.example.umcworkbook.entity.Mission;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;

public class MissionConverter {

    public static MissionResDto.PreviewDto toPreviewDto(
            Mission mission
    ) {
        return MissionResDto.PreviewDto.builder()
                .restaurantName(mission.getRestaurant().getName())
                .category(mission.getRestaurant().getCategory().getName())
                .price(mission.getPrice())
                .point(mission.getPoint())
                .days_left(mission.getDaysLeft())
                .build();
    }

    public static MissionResDto.PreviewListDto toPreviewListDto(
            Page<Mission> result
    ){
        return MissionResDto.PreviewListDto.builder()
                .missionList(result.getContent().stream()
                        .map(MissionConverter::toPreviewDto)
                        .collect(Collectors.toList())
                )
                .listSize(result.getSize())
                .totalPage(result.getTotalPages())
                .totalElements(result.getTotalElements())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .build();
    }
}
