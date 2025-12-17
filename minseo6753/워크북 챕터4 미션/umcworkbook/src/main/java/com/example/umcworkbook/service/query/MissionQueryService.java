package com.example.umcworkbook.service.query;

import com.example.umcworkbook.dto.res.MissionResDto;

public interface MissionQueryService {
    MissionResDto.PreviewListDto findRestaurantMissions(
            Long restaurantId,
            Integer page
    );
}
