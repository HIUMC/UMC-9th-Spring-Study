package com.example.umcworkbook.converter;

import com.example.umcworkbook.dto.res.MemberMissionResDto;
import com.example.umcworkbook.entity.MemberMission;

public class MemberMissionConverter {

    public static MemberMissionResDto.PreviewDto toPreviewDto(
            MemberMission memberMission
    ) {
        return MemberMissionResDto.PreviewDto.builder()
                .point(memberMission.getMission().getPoint())
                .status(memberMission.getMissionStatus().getMessage())
                .restaurantName(memberMission.getMission().getRestaurant().getName())
                .price(memberMission.getMission().getPrice())
                .build();
    }
}
